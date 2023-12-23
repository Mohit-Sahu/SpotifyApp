import { Component, OnInit } from '@angular/core';
import { User, UserFormValidation } from 'src/app/_model/user';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/_services/user.service';
import Swal from 'sweetalert2';


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

  constructor(private fb: FormBuilder, private userService: UserService,private routes:Router) {
    this.userForm = this.fb.group({
      email: [this.defaultUser.email, [Validators.required, Validators.email]],
      username: [this.defaultUser.username, Validators.required],
      firstName: [this.defaultUser.firstName, Validators.required],
      lastName: [this.defaultUser.lastName, Validators.required],
      password: [this.defaultUser.password, [Validators.required, Validators.minLength(6)]],
      confirmpassword: [this.defaultUser.confirmpassword, [Validators.required, Validators.minLength(6)]],
      number: [this.defaultUser.number, [Validators.required,Validators.pattern('[0-9]*'), Validators.minLength(10)]],
      dateOfBirth: [this.defaultUser.dateOfBirth || '', Validators.required],
      roles: [this.defaultUser.roles || '', Validators.required],
      securityQuestion: [this.defaultUser.securityQuestion || '', Validators.required],
      securityAnswer: [this.defaultUser.securityAnswer || '', Validators.required],
      shareData: [false]
    }, { validators: this.passwordMatchValidator });
  }

  ngOnInit(): void {}

  proceed() {
    this.proceedClicked = true;
  }

  signUp() {
    // Implement your signup logic here
    console.log(this.userForm.value);
    if (this.userForm.value) {
      // Call the service to send the data
      this.userService.registerNewUser(this.userForm.value).subscribe(
        (response: any) => {
          // Handle success response if needed
          console.log('User registered successfully', response);
          Swal.fire('Registered Successfully!');
           this.routes.navigate(['/login']);
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
    const confirmPassword = group.get('confirmpassword')?.value;
  
    if (password && confirmPassword) {
      return password === confirmPassword ? null : { passwordMismatch: true };
    }
  
    return null;
  }
}
