import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppGlobals} from '../models/appGlobals';
import {Estacion} from '../models/estacion';

@Injectable({
    providedIn: 'root'
})
export class EstacionService {

    url: string;
    httpHeadersPOST: HttpHeaders;

    constructor(private http: HttpClient, private appGlobals: AppGlobals) {
        this.url = appGlobals.ip + 'Estacion';
        this.httpHeadersPOST = new HttpHeaders({
                'Content-Type': 'application/json'
            }
        );
    }

    get() {
        return this.http.get(this.url + '?max=-1');
    }

    post(estacion: Estacion) {
        return this.http.post(this.url, JSON.stringify(estacion), {headers: this.httpHeadersPOST});
    }

    put(estacion: Estacion) {
        return this.http.put(this.url + '/' + estacion.id, JSON.stringify(estacion), {headers: this.httpHeadersPOST});
    }

    delete(estacion: Estacion) {
        return this.http.delete(this.url + '/' + estacion.id);
    }
}
