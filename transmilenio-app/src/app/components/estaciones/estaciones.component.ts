import {Component, OnInit} from '@angular/core';
import {Troncal} from '../../models/troncal';
import {TroncalService} from '../../services/troncal.service';
import Swal from 'sweetalert2';
import {Estacion} from '../../models/estacion';
import {EstacionService} from '../../services/estacion.service';

@Component({
    selector: 'app-estaciones',
    templateUrl: './estaciones.component.html',
    styleUrls: ['./estaciones.component.scss']
})
export class EstacionesComponent implements OnInit {

    troncales: Array<Troncal> = [];
    estacion: Estacion;
    estaciones: Array<Estacion> = [];
    currentPage;

    constructor(private estacionService: EstacionService, private troncalService: TroncalService) {
        this.estacion = new Estacion();
        this.loadTroncales();
        this.loadEstaciones();
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

    loadEstaciones(): Estacion[] {
        this.estacionService.get().subscribe((data: Estacion[]) => {
            this.estaciones = data;
        }, error => {
            Swal.fire(
                'Ups!',
                'Algo salio mal!' + error.message,
                'warning'
            );
        });
        return null;
    }

    getTtroncal(id): string {
        if (id['id']) {
            id = id['id'];
        }
        for (let troncal of this.troncales) {
            if (troncal.id == id) {
                return troncal.nombre_troncal;
            }
        }
        return 'No encontrado';
    }

    clearEstacion() {
        this.estacion = new Estacion();
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    guardar() {
        if (this.estacion.imagen_estacion !== undefined) {
            if (this.estacion.id == undefined) {
                this.estacionService.post(this.estacion).subscribe((data: Estacion) => {
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
                        this.estacion = new Estacion();
                        this.loadEstaciones();
                    } else {
                        this.estacionService.get().subscribe((data: Estacion[]) => {
                            this.estaciones = data;
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
                this.estacionService.put(this.estacion).subscribe((data: Estacion) => {
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

    editar(v) {
        this.estacion = v;
        this.estacion.troncal = v.troncal_id['id'];
    }

    eliminar(v) {
        this.estacionService.delete(v).subscribe(r => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });
            this.loadEstaciones();
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

    ngOnInit() {
    }

}
