import {Component ,OnInit} from '@angular/core';
import Swal from "sweetalert2";

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
        const Toast = Swal.mixin({
            toast: true,
            position: 'top',
            showConfirmButton: false,
            timer: 3000
        });

        Toast.fire({
            type: 'info',
            title: 'Cierre de sesión exitosa'
        })
    }

    ngOnInit(): void {
    }
}
