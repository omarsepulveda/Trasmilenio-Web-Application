import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VehiculosService {

  url: string;
  httpHeaders: HttpHeaders;

  constructor(private http: HttpClient) {
    this.url = '';
    this.httpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
        }
    );
  }

  getAll() {
    return this.http.get(this.url, {headers: this.httpHeaders});
  }

}
