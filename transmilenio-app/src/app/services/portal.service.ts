import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppGlobals} from '../models/appGlobals';
import {Portal} from '../models/Portal';

@Injectable({
    providedIn: 'root'
})
export class PortalService {

    url: string;
    httpHeadersPOST: HttpHeaders;

    constructor(private http: HttpClient, private appGlobals: AppGlobals) {
        this.url = appGlobals.ip + 'Portal';
        this.httpHeadersPOST = new HttpHeaders({
                'Content-Type': 'application/json'
            }
        );
    }

    get() {
        return this.http.get(this.url + '?max=-1');
    }

    post(portal: Portal) {
        return this.http.post(this.url, JSON.stringify(portal), {headers: this.httpHeadersPOST});
    }

    put(portal: Portal) {
        return this.http.put(this.url + '/' + portal.id, JSON.stringify(portal), {headers: this.httpHeadersPOST});
    }

    delete(portal: Portal) {
        return this.http.delete(this.url + '/' + portal.id);
    }
}
