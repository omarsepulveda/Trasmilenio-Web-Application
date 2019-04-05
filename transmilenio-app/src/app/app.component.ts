import {Component ,OnInit} from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
    conClase: string;


    constructor() {
        this.conClase = 'home';
    }

    getLocalStorage(key){
        return localStorage.getItem(key);
    }

    closeSession(){
        localStorage.clear();
    }

    ngOnInit(): void {
    }
}
