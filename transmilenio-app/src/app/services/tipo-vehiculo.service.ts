import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TipoVehiculo} from '../models/tipo-vehiculo';
import {AppGlobals} from '../models/appGlobals';
import {Vehiculo} from '../models/vehiculo';

@Injectable({
    providedIn: 'root'
})
export class TipoVehiculoService {

    url: string;
    httpHeadersGET: HttpHeaders;
    httpHeadersPOST: HttpHeaders;

    constructor(private http: HttpClient, private appGlobals: AppGlobals) {
        this.url = appGlobals.ip + 'TipoVehiculo';
        this.httpHeadersGET = new HttpHeaders({
                'Content-Type': 'text/plain',
            }
        );

        this.httpHeadersPOST = new HttpHeaders({
                'Content-Type': 'application/json'
            }
        );
    }

    get() {
        return this.http.get(this.url+'?max=-1');
    }

    post(tipo: TipoVehiculo) {
        return this.http.post(this.url, JSON.stringify(tipo), {headers: this.httpHeadersPOST});
    }

    put(tipo: TipoVehiculo) {
        return this.http.put(this.url + '/' + tipo.id, JSON.stringify(tipo), {headers: this.httpHeadersPOST});
    }

    delete(tipo: TipoVehiculo) {
        return this.http.delete(this.url + '/' + tipo.id);
    }
}
