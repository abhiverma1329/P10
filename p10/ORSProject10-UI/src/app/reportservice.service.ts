import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportserviceService {

  private baseUrl='Jasper'
  constructor(private http:HttpClient) { }

  generateReport() :Observable<Blob>{
    debugger
    const headers= new HttpHeaders({'Content-Type':'application/pdf'});
    return this.http.get<Blob>('http://localhost:8084/Jasper/report',{headers, responseType:'blob' as 'json'});
    
  }
}
