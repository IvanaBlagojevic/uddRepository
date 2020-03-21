import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MagazineService {

  constructor(private httpClient: HttpClient) { }

  url = "http://localhost:8181/magazine/";

  getAll(): Observable<any>{
    return this.httpClient.get(this.url+'all/');
  }

}
