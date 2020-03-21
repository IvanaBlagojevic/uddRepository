import { Component, OnInit } from '@angular/core';
import { UserDTO } from '../model/UserDTO';
import { AuthLoginInfo } from '../auth/login-info';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from '../services/userService/user.service';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  email : string = "";
  password : string = "";
  user : UserDTO;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  loginInfo: AuthLoginInfo;

  constructor(private authService: AuthService, private router: ActivatedRoute, private tokenStorage: TokenStorageService, private us: UserService) { }

  ngOnInit() {
  }

  login(){
    if(this.isBlank(this.email))
    {
      alert("Morate uneti email");
    }else if(this.isBlank(this.password))
    {
      alert("Morate uneti lozinku");
    }else
    {
      
      this.us.getUserByEmail(this.email).subscribe(data =>{
       
        
        this.user = data as UserDTO;
        
        if(this.user == undefined)
        {
          alert("Register first");
        }/*else if(this.user.password != this.password)
        {
          console.log(this.user.password);
          console.log(this.password);
          alert("Check password");
        }*/else
        {
          
          this.loginInfo = new AuthLoginInfo(
            this.email,
            this.password);
          
          console.log("Email " + this.loginInfo.email);
          console.log("Pass " + this.loginInfo.password);
          this.authService.attemptAuth(this.loginInfo).subscribe(
            data => {
              this.tokenStorage.saveToken(data.token);
              //this.tokenStorage.saveUsername(data.email);
              //this.tokenStorage.saveAuthorities(data.authorities);
      
              this.isLoginFailed = false;
              this.isLoggedIn = true;
              //this.roles = this.tokenStorage;
              alert("Succesful");
              window.location.href = "https://localhost:4200";
            },err =>{this.handleAuthError(err)}
          );

          
        
		}
	  },err =>{this.handleError(err)});
    }
    
  }

  isBlank(str) {
    return (!str || /^\s*$/.test(str));
  }

  handleError(err: HttpErrorResponse) {
  
    if (err.status === 404) {
      alert('User with given email and password doesn t exist!');
    }else if(err.status === 406) {
      alert('Given password is incorrect!');
    }else if(err.status === 401){
      alert('Unauthorized!');
    }
    
  }

  handleAuthError(err : HttpErrorResponse) {

    if(err.status === 403){
      alert("Check your email, you need to confirm registration first!");
    }else
    {
      alert("Probleem");
    }
  }

}
