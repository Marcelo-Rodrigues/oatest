import { Injectable, OnInit } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';

@Injectable()
export class AuthService {

  constructor(private http: Http) { }

  request() {
    const headers = new Headers();
    const token = 'def';

    headers.append('Authorization', `Bearer ${token}`);

    const options = new RequestOptions({ headers: headers });

    this.http.get('http://localhost:8080/oatest/cliente')
      .subscribe(res => console.log(res));

    this.http.get('http://localhost:8080/oatest/clientes', options)
      .subscribe(res => console.log(res));
  }
}
