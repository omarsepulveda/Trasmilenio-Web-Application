import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import {VehiculosService} from '../../services/vehiculos.service';
import {Vehiculo} from '../../models/vehiculo';
import {TipoVehiculoService} from '../../services/tipo-vehiculo.service';
import {TipoVehiculo} from '../../models/tipo-vehiculo';

@Component({
    selector: 'app-index',
    templateUrl: './index.component.html',
    styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit {

    usuario: any;
    data: any = {correo: 'admin', contrasena: 'admin'};
    public chartType: string = 'bar';
    title = '';
    values: number[] = [];
    labels: string[] = [];
    aux: object[] = [];
    auxVehiculos: Vehiculo[] = [];
    file: File;
    contentFile: string;

    constructor(private router: Router, private vehiculosService: VehiculosService, private tipos: TipoVehiculoService) {
        this.usuario = {correo: '', contrasena: ''};
        this.fillVehiculos();
        this.vehiculosService.get().subscribe((vehiculos: Vehiculo[]) => {
            this.auxVehiculos = vehiculos;
        });
    }

    async showUploadFile() {
        const {value: file} = await Swal.fire({
            title: 'Select CSV',
            input: 'file',
            inputAttributes: {
                'accept': 'file/csv',
                'aria-label': 'Sube el archivo CSV'
            }
        });

        if (file) {
            let timerInterval;
            Swal.fire({
                title: 'Cargando datos', html: 'Espere un momento por favor', onBeforeOpen: () => {
                    Swal.showLoading();
                    timerInterval = setInterval(() => {}, 100);
                },
                onClose: () => {
                    clearInterval(timerInterval);
                }
            });
            const reader = new FileReader;
            reader.onload = (e) => {
                var result = [];
                const csv = e.target.result;
                if (csv !== undefined) {
                    const lines = csv.split('\n');
                    const headers = lines[0].split(',');
                    for (let i = 1; i < lines.length; i++) {
                        const obj = {};
                        const currentline = lines[i].split(',');
                        for (let j = 0; j < headers.length; j++) {
                            obj[headers[j]] = currentline[j];
                        }
                        result.push(obj);
                    }
                }
                Swal.fire({
                    title: 'Oops...',
                    text: JSON.stringify(result),
                });
                for (let v of result) {
                    this.vehiculosService.post(v).subscribe();
                }
                Swal.close();
                this.router.navigate(['vehiculos']);
            };
            reader.readAsText(file);
        }
    }

    fillVehiculos() {
        this.tipos.get().subscribe((tipos: TipoVehiculo[]) => {
            for (let tipo of tipos) {
                this.vehiculosService.get().subscribe((vehiculos: Vehiculo[]) => {
                    this.aux = [];
                    for (let vehiculo of vehiculos) {
                        if (vehiculo.tipo['id'] === tipo.id) {
                            this.aux.push(vehiculo);
                        }
                    }
                    this.values.push(this.aux.length);
                });
                this.labels.push(tipo.nombre_tipo_vehiculo);
            }
        });
    }

    async showGenerate() {
        const {value: max} = await Swal.fire({
            title: 'Generador de Vehículos',
            input: 'number',
            inputPlaceholder: '# registros'
        });
        let timerInterval;
        if (max) {
            Swal.fire({
                title: 'Generando datos', html: 'Espere un momento por favor', onBeforeOpen: () => {
                    Swal.showLoading();
                    timerInterval = setInterval(() => {
                    }, 100);
                },
                onClose: () => {
                    clearInterval(timerInterval);
                }
            });

            this.vehiculosService.generador(max).subscribe(data => {
                Swal.close();
                this.router.navigate(['vehiculos']);
            });
        }
    }

    public chartDatasets: Array<any> = [
        // {data: [65, 59, 80, 81, 56, 55, 40], label: 'My First dataset'}
        {data: this.values, label: 'Vehiculos'}
    ];

    // public chartLabels: Array<any> = ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'];
    public chartLabels: Array<any> = this.labels;

    public chartColors: Array<any> = [
        {
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 2,
        }
    ];
    public chartOptions: any = {
        responsive: true
    };

    public chartClicked(e: any): void {
    }

    public chartHovered(e: any): void {
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    onSubmit() {
        if (this.data.correo === this.usuario.correo && this.data.contrasena === this.usuario.contrasena) {
            localStorage.setItem('correo', this.usuario.correo);
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });

            Toast.fire({
                type: 'success',
                title: 'Bienvenido ' + this.data.correo
            });
        } else {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });

            Toast.fire({
                type: 'warning',
                title: 'usuario y/o contraseña incorrectos'
            });
        }
        // console.log(JSON.stringify(this.usuario));
    }

    ngOnInit() {
    }

}
