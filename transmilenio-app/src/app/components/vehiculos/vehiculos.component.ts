import {Component, OnInit} from '@angular/core';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
    selector: 'app-vehiculos',
    templateUrl: './vehiculos.component.html',
    styleUrls: ['./vehiculos.component.scss']
})
export class VehiculosComponent implements OnInit {

    tipos = [
        {value: '1', label: 'Microbus'},
        {value: '2', label: 'Bus'},
        {value: '3', label: 'Articulado'},
        {value: '4', label: 'Alimentador'},
        {value: '5', label: 'Biarticulado'},
        {value: '6', label: 'Duales'},
    ];

    vehiculo: any;

    vehiculos: any;

    constructor() {
        this.vehiculo = {matricula: '', codigo: '', id_tipo: ''};
        this.vehiculos = [
            {id: 1, matricula: 'KEQ457', codigo: 'A107', tipo: 'Bus', id_tipo: 2},
            {id: 2, matricula: 'EYZ619', codigo: 'B203', tipo: 'Microbus', id_tipo: 1},
            {id: 3, matricula: 'FAC572', codigo: 'E604', tipo: 'Articulado', id_tipo: 3},
            {id: 4, matricula: 'RSV171', codigo: 'C707', tipo: 'Articulado', id_tipo: 3},
            {id: 5, matricula: 'TDB049', codigo: 'A809', tipo: 'Biarticulado', id_tipo: 5},
            {id: 6, matricula: 'YFN679', codigo: 'D305', tipo: 'Bus', id_tipo: 2},
            {id: 7, matricula: 'UGM020', codigo: 'A104', tipo: 'Biarticulado', id_tipo: 5},
            {id: 8, matricula: 'IHL367', codigo: 'C406', tipo: 'Bus', id_tipo: 2},
            {id: 9, matricula: 'OJJ001', codigo: 'A701', tipo: 'Duales', id_tipo: 6},
            {id: 10, matricula: 'PKW715', codigo: 'A200', tipo: 'Bus', id_tipo: 2},
        ];
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    guardar() {
        for(let t of this.tipos){
            if (this.vehiculo.id_tipo === t.value){
                this.vehiculo.tipo = t.label;
                this.vehiculo.id = this.vehiculos.length+1;
                break;
            }
        }
        this.vehiculos.push(this.vehiculo);
    }

    editar(v) {
        this.limpiar();
        this.vehiculo = v;
    }

    eliminar(v) {
        this.removeItemFromArr(this.vehiculos, v);
    }

    removeItemFromArr(arr, item) {
        let i = arr.indexOf(item);
        arr.splice(i, 1);
    }

    limpiar() {
        this.vehiculo = {matricula: '', codigo: '', id_tipo: ''};
    }

    ngOnInit() {
    }

}
