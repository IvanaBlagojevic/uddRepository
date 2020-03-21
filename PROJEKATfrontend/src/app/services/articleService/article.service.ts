import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  constructor(private httpClient: HttpClient) { }

  url = "http://localhost:8181/article/";
  urlUDD = "http://localhost:8181/elasticarticle/";

  //upp
  postArticle(article: any, o: any): Observable<any>{
    return this.httpClient.post(this.url+'post/'+o, article);
  }

  postFile( fileToUpload: File) {
    const formData: FormData = new FormData();  
    formData.append("File", fileToUpload);
    return this.httpClient.post(this.url + 'uploadPDF/', formData,{ responseType: 'text'});
      
  }

  choosenReviewers(article: any, o: any): Observable<any>{
    return this.httpClient.put(this.url+'choosenReviewers/'+o, article);
  }

  //udd
  downloadFile(ime : string)
  {
    return this.httpClient.get(this.urlUDD + "download/"+ime ,{responseType : 'blob', headers:new HttpHeaders().append('Content-Type','application/json')});
  }

  getById(id: any): Observable<any>{
    return this.httpClient.get(this.urlUDD+'getOne/'+id);
  }

}
