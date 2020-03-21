import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  url = "http://localhost:8181/search/";

  constructor(private httpClient: HttpClient) { }

  searchBasic(field : any, query : any): Observable<any>{
    return this.httpClient.post(this.url+'basic/'+field, query);
  }

  searchAdvanced(list : any): Observable<any>{
    return this.httpClient.post(this.url+'advanced', list);
  }

  searchReviewers(a : any, obj:any): Observable<any>{
    console.log("obj "+obj.fields);
    console.log("obj more "+obj.moreLikeThis);
    console.log("obj domain"+obj.isInDomain);
    return this.httpClient.post(this.url+'searchReviewers/'+a, obj);
  }
}
