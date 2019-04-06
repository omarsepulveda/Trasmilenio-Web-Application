import {Component, OnInit} from '@angular/core';
import {TipoVehiculoService} from '../../services/tipo-vehiculo.service';
import {VehiculosService} from '../../services/vehiculos.service';
import {Vehiculo} from '../../models/vehiculo';
import Swal from 'sweetalert2';
import {TipoVehiculo} from '../../models/tipo-vehiculo';

@Component({
    selector: 'app-vehiculos',
    templateUrl: './vehiculos.component.html',
    styleUrls: ['./vehiculos.component.scss']
})
export class VehiculosComponent implements OnInit {

    tipos: Array<TipoVehiculo> = [];
    vehiculo: Vehiculo;
    vehiculos: Array<Vehiculo> = [];

    constructor(private vehiculosService: VehiculosService, private tiposVehiculosService: TipoVehiculoService) {
        this.vehiculo = new Vehiculo();
        this.loadTipos();
        this.loadVehiculos();
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

    loadVehiculos(): Vehiculo[] {
        this.vehiculosService.get().subscribe((data: Vehiculo[]) => {
            this.vehiculos = data;
        }, error => {
            Swal.fire(
                'Ups!',
                'Algo salio mal!' + error.message,
                'warning'
            );
        });
        return null;
    }

    getTipo(id): string {
        if (id['id']) {
            id = id['id'];
        }
        for (let tipo of this.tipos) {
            if (tipo.id == id) {
                return tipo.nombre_tipo_vehiculo;
            }
        }
        return 'No encontrado';
    }

    clearVehiculo() {
        this.vehiculo = new Vehiculo();
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    guardar() {
        if (this.vehiculo.tipo !== undefined) {
            if (this.vehiculo.id == undefined) {
                this.vehiculosService.post(this.vehiculo).subscribe((data: Vehiculo) => {
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
                        this.vehiculos.push(data);
                    }else{
                        this.vehiculosService.get().subscribe((data: Vehiculo[]) => {
                            this.vehiculos = data;
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
                this.vehiculosService.put(this.vehiculo).subscribe((data: Vehiculo) => {
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
        this.vehiculo = v;
        this.vehiculo.tipo = v.tipo['id'];
    }

    eliminar(v) {
        this.vehiculosService.delete(v).subscribe(r => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });

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
        this.removeItemFromArr(this.vehiculos, v);
    }

    removeItemFromArr(arr, item) {
        let i = arr.indexOf(item);
        arr.splice(i, 1);
    }

    ngOnInit() {
    }

}
