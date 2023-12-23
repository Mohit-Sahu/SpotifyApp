import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import { ForgotPassword } from '../_model/ForgotPassword';
import { User } from '../_model/user'; 
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  _baseUrlsignup="http://localhost:8081/api/v1.0";
  _baseUrl="http://localhost:8082/api/v1.0";

  requestHeader = new HttpHeaders({
    'NoAuth': "True"
  });

  constructor(private httpClient: HttpClient,private userAuthService: UserAuthService) { }

  public login(loginData:any){
    return this.httpClient.post(this._baseUrl+"/authentication"+"/login",loginData,{headers : this.requestHeader});
  }

  public registerNewUser(user:User){
    return this.httpClient.post(this._baseUrlsignup+"/userProfile/register",user);

  }




  public forUser() {
    return this.httpClient.get(this._baseUrlsignup + '/forUser', {
      responseType: 'text',
    });
  }


  public forAdmin() {
    return this.httpClient.get(this._baseUrl + '/forAdmin', {
      responseType: 'text',
    });
  }

  // changePassword(loginId:string,forgotPassword:ForgotPassword){
  //   return this.httpClient.put(this._baseUrl+"/"+loginId+'/forgot',forgotPassword, { responseType: 'text' });
  // }

  public roleMatch(allowedRoles : any): boolean {
    console.log(allowedRoles);
    let isMatch = false;
    const userRoles: any = this.userAuthService.getRoles();
    console.log(userRoles)
    if (userRoles != null && userRoles) {
        for (let j = 0; j < allowedRoles.length; j++) {
          if (userRoles === allowedRoles[j]) {
            isMatch = true;
            return isMatch;
          } else {
            return isMatch;
          }
        }
      
    }
    return isMatch;
  }
}
