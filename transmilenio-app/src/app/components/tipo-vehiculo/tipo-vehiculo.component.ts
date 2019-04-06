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

    constructor(private tiposVehiculosService: TipoVehiculoService) {
        this.loadTipos();
    }

    ngOnInit() {
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
