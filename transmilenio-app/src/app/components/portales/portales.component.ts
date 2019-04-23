import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {Troncal} from '../../models/troncal';
import {Portal} from '../../models/portal';
import {PortalService} from '../../services/portal.service';
import {TroncalService} from '../../services/troncal.service';

@Component({
    selector: 'app-portales',
    templateUrl: './portales.component.html',
    styleUrls: ['./portales.component.scss']
})
export class PortalesComponent implements OnInit {

    troncales: Array<Troncal> = [];
    portal: Portal;
    portales: Array<Portal> = [];
    currentPage;

    constructor(private portalService: PortalService, private troncalService: TroncalService) {
        this.portal = new Portal();
        this.loadTroncales();
        this.loadPortales();
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

    loadPortales(): Portal[] {
        this.portalService.get().subscribe((data: Portal[]) => {
            this.portales = data;
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

    clearPortal() {
        this.portal = new Portal();
    }

    getLocalStorage(key) {
        return localStorage.getItem(key);
    }

    guardar() {
        if (this.portal.imagen_portal !== undefined) {
            if (this.portal.id == undefined) {
                this.portalService.post(this.portal).subscribe((data: Portal) => {
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
                        this.portal = new Portal();
                        this.loadPortales();
                    } else {
                        this.portalService.get().subscribe((data: Portal[]) => {
                            this.portales = data;
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
                this.portalService.put(this.portal).subscribe((data: Portal) => {
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
        this.portal = v;
        this.portal.troncal = v.troncal_id['id'];
    }

    eliminar(v) {
        this.portalService.delete(v).subscribe(r => {
            const Toast = Swal.mixin({
                toast: true,
                position: 'top',
                showConfirmButton: false,
                timer: 3000
            });
            this.loadPortales();
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
