import http from 'k6/http';
import { sleep, check } from 'k6';
import { Counter } from 'k6/metrics';

export const requests = new Counter('http_reqs');

export default function () {

    const contaCorrenteGetUrl = 'http://a.localhost/contacorrente/saldo';
    const contaCorrentePostUrl = 'http://a.localhost/contacorrente/transaction';
    const params = {
      headers: {
        'id': '1',
      },
    };

    const requests = {
        'ContaCorrenteG': {
          method: 'GET',
          url: contaCorrenteGetUrl,
          params: params,
        },
        'ContaCorrenteP': {
          method: 'POST',
          url: contaCorrentePostUrl,
          params: params,
        },
    };

    for(var i = 0; i < 50; i++) {
        http.batch(requests);
    }
}
