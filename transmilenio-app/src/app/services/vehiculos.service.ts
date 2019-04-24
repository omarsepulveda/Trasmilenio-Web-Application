import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppGlobals} from '../models/appGlobals';
import {Vehiculo} from '../models/vehiculo';

@Injectable({
    providedIn: 'root'
})
export class VehiculosService {

    url: string;
    httpHeadersGET: HttpHeaders;
    httpHeadersPOST: HttpHeaders;

    constructor(public http: HttpClient, private appGlobals: AppGlobals) {
        this.url = appGlobals.ip + 'Vehiculo';
        this.httpHeadersGET = new HttpHeaders({
                'Content-Type': 'text/plain',
            }
        );

        this.httpHeadersPOST = new HttpHeaders({
                'Content-Type': 'application/json',
                'Accept': 'text/plain'
            }
        );
    }

    get() {
        return this.http.get(this.url + '?max=-1');
    }

    post(vehiculo: Vehiculo) {
        return this.http.post(this.url, JSON.stringify(vehiculo), {headers: this.httpHeadersPOST});
    }

    put(vehiculo: Vehiculo) {
        return this.http.put(this.url + '/' + vehiculo.id, JSON.stringify(vehiculo), {headers: this.httpHeadersPOST});
    }

    delete(vehiculo: Vehiculo) {
        return this.http.delete(this.url + '/' + vehiculo.id);
    }

    generador(cantidad: number) {
        return this.http.get(this.appGlobals.ip + 'Generar?max=' + cantidad);
    }
}
