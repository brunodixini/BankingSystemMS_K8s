import http from 'k6/http';
import { sleep, check } from 'k6';
import { Counter } from 'k6/metrics';

export const requests = new Counter('http_reqs');

export default function () {

    const cashbackGetUrl = 'http://a.localhost/cashback/totalpago';
    const cashbackPostUrl = 'http://a.localhost/cashback/pagamento';
    const params = {
      headers: {
        'id': '1',
      },
    };

    const requests = {
        'CashbackG': {
          method: 'GET',
          url: cashbackGetUrl,
          params: params,
        },
        'CashbackP': {
          method: 'POST',
          url: cashbackPostUrl,
          params: params,
        },
    };

    for(var i = 0; i < 50; i++) {
        http.batch(requests);
    }
}
