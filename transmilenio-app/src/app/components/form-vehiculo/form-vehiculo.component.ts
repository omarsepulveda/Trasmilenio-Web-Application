import {Component, OnInit} from '@angular/core';
import {Vehiculo} from '../../models/vehiculo';

@Component({
    selector: 'app-form-vehiculo',
    templateUrl: './form-vehiculo.component.html',
    styleUrls: ['./form-vehiculo.component.scss']
})
export class FormVehiculoComponent implements OnInit {

    private vehiculo: Vehiculo;

    constructor() {
    }

    ngOnInit() {

    }

}
