import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScfieldService {

  constructor(private httpClient: HttpClient) { }

  url = "http://localhost:8181/scfield/";
 

  getFields(){
    return this.httpClient.get(this.url + 'get') as Observable<any>
  }
}
