import { Component, OnInit } from '@angular/core';
import { AuthService } from './shared/auth.service';

@Component({
  selector: 'my-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  authToken: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.request();
  }

  setAuthToken(token: string) {
    this.authToken = token;
  }

}
