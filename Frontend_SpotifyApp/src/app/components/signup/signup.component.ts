import { Component, OnInit } from '@angular/core';
import { User, UserFormValidation } from 'src/app/_model/user';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  userForm: FormGroup;
  proceedClicked = false;

  defaultUser: User = {
    id: 0,
    username: '',
    firstName: '',
    lastName: '',
    number: 0,
    dateOfBirth: '',
    email: '',
    roles: ["User"], // Initialize roles as an empty array
    password: '',
    confirmpassword: '',
    securityQuestion: 'What is your favorite color?',
    securityAnswer: 'Blue'
  };

  constructor(private fb: FormBuilder,private userService:UserService) {
    this.userForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      username: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmpassword: ['', [Validators.required, Validators.minLength(6)]],
      number: ['', [Validators.pattern('[0-9]*'),Validators.minLength(10)]],
      shareData: [false]
    }, { validators: this.passwordMatchValidator });

    this.userForm.patchValue(this.defaultUser);
  }

  ngOnInit(): void {}

  proceed() {
    this.proceedClicked = true;
  }

  signUp() {
    // Implement your signup logic here
    console.log(this.userForm.value);
    if (this.userForm.valid) {
      // Call the service to send the data
      this.userService.registerNewUser(this.userForm.value).subscribe(
        (response: any) => {
          // Handle success response if needed
          console.log('User registered successfully', response);
        },
        (error: any) => {
          // Handle error response if needed
          console.error('Error during user registration', error);
        }
      );
    } else {
      // Form is invalid, handle accordingly (e.g., display error messages)
      console.error('Form is invalid. Cannot submit.');
    }
  
  }

  passwordMatchValidator(group: FormGroup): { [s: string]: boolean } | null {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
  
    if (password && confirmPassword) {
      return password === confirmPassword ? null : { passwordMismatch: true };
    }
  
    return null;
  }
  
}