import { Component, OnInit } from '@angular/core';
import { UserAuthService } from 'src/app/_services/user-auth.service';
import { UserService } from 'src/app/_services/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';  // Import NgForm

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {

  constructor(public userservice: UserService, private userAuthService: UserAuthService, private router: Router) { }

  ngOnInit(): void {
  }

  loginData = {
    username: '',
    password: '',
  };

  loginError = false;  // Variable to track login error

  login() {
    console.log(this.loginData);
    this.loginError = false;  // Reset the login error

    this.userservice.login(this.loginData).subscribe(
      (response: any) => {
        console.log(response);
        if (Array.isArray(response.roles) && response.roles.length > 0) {
          this.userAuthService.setRoles(response.roles[0].name);
          this.userAuthService.setToken(response.accessToken);

          const role = response.roles[0].name;
          console.log(role);
          if (role === 'ROLE_CUSTOMER') {
            this.router.navigate(['/home/songs']);
          } else {
            this.router.navigate(['/']);
          }
        }
      },
      (error) => {
        console.log(error);
        this.loginError = true;  // Set login error to true
      }
    );
  }
}