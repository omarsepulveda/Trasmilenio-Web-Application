import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
    selector: 'app-index',
    templateUrl: './index.component.html',
    styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

    usuario: any;
    data: any = {correo: 'admin@admin.com', contrasena: 'admin'};

    constructor(private router: Router) {
        this.usuario = {correo: '', contrasena: ''};
    }

    getLocalStorage(key){
        return localStorage.getItem(key);
    }

    onSubmit() {
        if (this.data.correo === this.usuario.correo && this.data.contrasena === this.usuario.contrasena) {
            localStorage.setItem('correo', this.usuario.correo);
        }else{
            const Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 3000
            });

            Toast.fire({
                type: 'warning',
                title: 'usuario y/o contraseña incorrectos'
            })
        }
        // console.log(JSON.stringify(this.usuario));
    }

    ngOnInit() {
    }

}
