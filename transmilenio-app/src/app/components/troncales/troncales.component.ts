import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Troncal} from '../../models/troncal';
import {TroncalService} from '../../services/troncal.service';

@Component({
    selector: 'app-troncales',
    templateUrl: './troncales.component.html',
    styleUrls: ['./troncales.component.scss']
})
export class TroncalesComponent implements OnInit {

    troncales: Array<Troncal> = [];
    troncal: Troncal;
    currentPage;

    constructor(private troncalService: TroncalService) {
        this.troncal = new Troncal();
        this.loadTroncales();
    }

    ngOnInit() {
    }

    clearObject() {
        this.troncal = new Troncal();
    }

    guardar() {
        if (this.troncal.letra_troncal !== undefined) {
            if (this.troncal.id == undefined) {
                this.troncalService.post(this.troncal).subscribe((data: Troncal) => {
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 3000
                    });

                    Toast.fire({
                        type: 'success',
                        title: 'Registro guardado.'
                    });
                    if (data) {
                        this.loadTroncales();
                        this.troncal = new Troncal();
                    } else {
                        this.troncalService.get().subscribe((data: Troncal[]) => {
                            this.troncales = data;
                        }, error => {
                            Swal.fire(
                                'Ups!',
                                'Algo salio mal!' + error.message,
                                'warning'
                            );
                        });
                    }
                }, error => {
                    Swal.fire(
                        'Ups!',
                        'Algo salio mal!' + error.message,
                        'warning'
                    );
                });
            } else {
                this.troncalService.put(this.troncal).subscribe((data: Troncal) => {
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top',
                        showConfirmButton: false,
                        timer: 3000
                    });

                    Toast.fire({
                        type: 'success',
                        title: 'Actualización exitosa.'
                    });
                }, error => {
                    Swal.fire(
                        'Ups!',
                        'Algo salio mal!' + error.message,
                        'warning'
                    );
                });
            }
        }
    }

    editar(vtroncal: Troncal) {
        this.troncal = vtroncal;
        this.troncal.id = vtroncal.id;
    }

    eliminar(vtroncal) {
        this.troncalService.delete(vtroncal).subscribe(r => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });
            this.loadTroncales();
            Toast.fire({
                type: 'success',
                title: 'Eliminación exitosa.'
            });
        }, error => {
            Swal.fire(
                'Ups!',
                'Algo salio mal!' + error.message,
                'warning'
            );
        });
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    loadTroncales() {
        this.troncalService.get().subscribe((data: Troncal[]) => {
            this.troncales = data;
        }, error => {
            Swal.fire(
                'Ups!',
                'Algo salio mal!' + error.message,
                'warning'
            );
        });
    }

}
