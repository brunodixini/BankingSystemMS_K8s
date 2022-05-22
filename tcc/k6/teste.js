import http from 'k6/http';
import { check, sleep } from 'k6';
import { Trend, Rate } from 'k6/metrics';

const listErrorRate = new Rate('Cashback errors');
const createErrorRate = new Rate('ContaCorrente errors');
const ListTrend = new Trend('Cashback');
const CreateTrend = new Trend('ContaCorrente');

export const options = {
  thresholds: {
    'Cashback': ['p(95)<10000'],
    'ContaCorrente': ['p(95)<10000'],
  },
};

export default function () {
  const cashbackUrl = 'http://a.localhost/cashback/totalpago';
  const ccontaCorrenteUrl = 'http://a.localhost/contacorrente/saldo';
  const params = {
    headers: {
      'Authorization': 'Token ffc62b27db68502eebc6e90b7c1476d29c581f4d',
      'Content-Type': 'application/json',
      'id': '1',
    },
  };

  const requests = {
    'Cashback': {
      method: 'GET',
      url: cashbackUrl,
      params: params,
    },
    'ContaCorrente': {
      method: 'GET',
      url: ccontaCorrenteUrl,
      params: params,
    },
  };

  var responses
  var listResp
  var createResp

  for(var i = 0; i < 30; i++) {
    responses = http.batch(requests);
    listResp = responses['Cashback'];
    createResp = responses['ContaCorrente'];

    sleep(1);
  }

  check(listResp, {
    'status is 200': (r) => r.status === 200,
  }) || listErrorRate.add(1);

  ListTrend.add(listResp.timings.duration);

  check(createResp, {
    'status is 201': (r) => r.status === 201,
  }) || createErrorRate.add(1);

  CreateTrend.add(createResp.timings.duration);
}
