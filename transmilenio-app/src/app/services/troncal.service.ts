import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppGlobals} from '../models/appGlobals';
import {Troncal} from '../models/troncal';

@Injectable({
  providedIn: 'root'
})
export class TroncalService {

  url: string;
  httpHeadersPOST: HttpHeaders;

  constructor(private http: HttpClient, private appGlobals: AppGlobals) {
    this.url = appGlobals.ip + 'Troncal';

    this.httpHeadersPOST = new HttpHeaders({
          'Content-Type': 'application/json'
        }
    );
  }

  get() {
    return this.http.get(this.url+'?max=-1');
  }

  post(troncal: Troncal) {
    return this.http.post(this.url, JSON.stringify(troncal), {headers: this.httpHeadersPOST});
  }

  put(troncal: Troncal) {
    return this.http.put(this.url + '/' + troncal.id, JSON.stringify(troncal), {headers: this.httpHeadersPOST});
  }

  delete(troncal: Troncal) {
    return this.http.delete(this.url + '/' + troncal.id);
  }
}
