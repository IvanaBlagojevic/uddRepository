import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MembershipFeesService {

  constructor(private httpClient: HttpClient) { }

  url = "https://localhost:8181/membershipFees/";

  getFields():Observable<any>{
    return this.httpClient.get(this.url + 'get');
  }
}
