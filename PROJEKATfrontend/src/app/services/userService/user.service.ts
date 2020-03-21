import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';
import { UserDTO } from 'src/app/model/UserDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = "https://localhost:8181/user/";

  constructor(private httpClient: HttpClient) { }

  startProcess(){
    return this.httpClient.get(this.url + 'get') as Observable<any>
  }

  postUser(user: any, o: any): Observable<any>{
    return this.httpClient.post(this.url + 'post/'.concat(o), user);
  }

  getConfirmForm(processInstance : any): Observable<any>{
    return this.httpClient.get(this.url + 'getConfirmForm/'.concat(processInstance));
  }

  confirmUser(user: any, o: any): Observable<any>{
    return this.httpClient.put(this.url + 'confirm/'.concat(o), user);
  }

  confirmReviewer(user: any, o: any): Observable<any>{
    return this.httpClient.put(this.url + 'confirmReviewer/'.concat(o), user);
  }

  getEditors(): Observable<any>{
    return this.httpClient.get(this.url + 'getEditorsSC');
  }

  getReviewers(): Observable<any>{
    return this.httpClient.get(this.url + 'getReviewers');
  }

  getUserByEmail(email : String){
    return this.httpClient.get(this.url + 'email/'+email+'/');
  }

}
