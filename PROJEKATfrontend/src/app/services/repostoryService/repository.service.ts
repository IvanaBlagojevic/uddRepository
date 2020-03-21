import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {

  constructor(private httpClient: HttpClient) { }

  url = "https://localhost:8181/welcome/";

  //svi taskovi jednog usera
  getTasks() : Observable<any>{
    return this.httpClient.get(this.url + 'get/tasks');
  }

  //jedan task po taskId-ju
  getTask(o : any) : Observable<any>{
    return this.httpClient.get(this.url + 'get/'.concat(o));
  }

  //pocinje se proces, prosledi se objekat i id procesa
  startProcess(o : any, send : any): Observable<any>{
    return this.httpClient.post(this.url + 'getStart/'.concat(o), send);
  }

   //jedan task po taskId-ju za coauthora
   submitTask(o : any, obj:any) : Observable<any>{
     ///post/{taskId}
    return this.httpClient.post(this.url + 'post/'.concat(o), obj);
  }

}
