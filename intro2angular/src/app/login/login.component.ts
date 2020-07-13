import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  success: boolean

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  loginUser(event) {
    event.preventDefault();

    const username =event.target.querySelector('#username');
    const password = event.target.querySelector('#password');
    this.authService.getUserDetails(username,password).subscribe(
      data => {
        this.success = data.success;
        if (this.success){
        // redirect to /admin
          this.router.navigate(['admin'])
          this.authService.setLoggedIn(true);
        }else {
        // invalid
          this.authService.setLoggedIn(false);
        }
      }

    );

    console.log(event);
  }
}
