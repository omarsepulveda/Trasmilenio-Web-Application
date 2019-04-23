import {Component, OnInit} from '@angular/core';
import {TipoVehiculo} from '../../models/tipo-vehiculo';
import Swal from "sweetalert2";
import {TipoVehiculoService} from '../../services/tipo-vehiculo.service';

@Component({
    selector: 'app-tipo-vehiculo',
    templateUrl: './tipo-vehiculo.component.html',
    styleUrls: ['./tipo-vehiculo.component.scss']
})
export class TipoVehiculoComponent implements OnInit {

    tipos: Array<TipoVehiculo> = [];
    tipo: TipoVehiculo;
    currentPage;

    constructor(private tiposVehiculosService: TipoVehiculoService) {
        this.tipo = new TipoVehiculo();
        this.loadTipos();
    }

    ngOnInit() {
    }

    clearObject() {
        this.tipo = new TipoVehiculo();
    }

    guardar() {
        if (this.tipo.nombre_tipo_vehiculo !== undefined) {
            if (this.tipo.id == undefined) {
                this.tiposVehiculosService.post(this.tipo).subscribe((data: TipoVehiculo) => {
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
                    if (data){
                        this.tipo = new TipoVehiculo();
                        this.loadTipos();
                    }else{
                        this.tiposVehiculosService.get().subscribe((data: TipoVehiculo[]) => {
                            this.tipos = data;
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
                this.tiposVehiculosService.put(this.tipo).subscribe((data: TipoVehiculo) => {
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

    editar(vTipo: TipoVehiculo) {
        this.tipo = vTipo;
        this.tipo.id = vTipo.id;
    }

    eliminar(vTipo) {
        this.tiposVehiculosService.delete(vTipo).subscribe(r => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });
            this.loadTipos();
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

    loadTipos() {
        this.tiposVehiculosService.get().subscribe((data: TipoVehiculo[]) => {
            this.tipos = data;
        }, error => {
            Swal.fire(
                'Ups!',
                'Algo salio mal!' + error.message,
                'warning'
            );
        });
    }
    showModal(tipo: TipoVehiculo){
        Swal.fire({
            title: tipo.nombre_tipo_vehiculo,
            text: tipo.descripcion_tipo_vehiculo,
            imageUrl: tipo.imagen_tipo_vehiculo,
            imageWidth: 400,
            imageHeight: 200,
            imageAlt: 'Custom image',
            animation: true
        })
    }


}
