import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UrlTree} from "@angular/router";
interface loginResponse {
  success:boolean
}
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedInStatus = JSON.parse(localStorage.getItem("loggedIn") || 'false');

  constructor(private httpClient:HttpClient) { }

  get isLoggedIn(){
    return JSON.parse(this.loggedInStatus.toString() || localStorage.getItem("loggedIn"));
  }

  getUserDetails(username, password){
    // post
    return this.httpClient.get<loginResponse>('/api/auth.json');
  }

  setLoggedIn(b: boolean) {
    this.loggedInStatus = b;
    localStorage.setItem("loggedIn",'true')
  }
}
