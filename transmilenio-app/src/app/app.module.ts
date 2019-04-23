import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {IndexComponent} from './components/index/index.component';
import {RouterModule, Routes} from '@angular/router';
import {VehiculosComponent} from './components/vehiculos/vehiculos.component';
import {TroncalesComponent} from './components/troncales/troncales.component';
import {PortalesComponent} from './components/portales/portales.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {SweetAlert2Module} from '@sweetalert2/ngx-sweetalert2';
import {TipoVehiculoService} from './services/tipo-vehiculo.service';
import {VehiculosService} from './services/vehiculos.service';
import {AppGlobals} from './models/appGlobals';
import { TipoVehiculoComponent } from './components/tipo-vehiculo/tipo-vehiculo.component';
import {AngularPaginatorModule} from 'angular-paginator';
import { EstacionesComponent } from './components/estaciones/estaciones.component';
import {TroncalService} from './services/troncal.service';
import {PortalService} from './services/portal.service';
import {EstacionService} from './services/estacion.service';

const appRoutes: Routes = [
    {path: '', component: IndexComponent},
    {path: 'vehiculos', component: VehiculosComponent},
    {path: 'troncales', component: TroncalesComponent},
    {path: 'portales', component: PortalesComponent},
    {path: 'tipos-vehiculo', component: TipoVehiculoComponent},
    {path: 'estaciones', component: EstacionesComponent},
];

@NgModule({
    declarations: [
        AppComponent,
        IndexComponent,
        VehiculosComponent,
        TroncalesComponent,
        PortalesComponent,
        TipoVehiculoComponent,
        EstacionesComponent,
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes, {initialNavigation: 'enabled'}),
        MDBBootstrapModule.forRoot(),
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AngularPaginatorModule,
        SweetAlert2Module.forRoot({
            buttonsStyling: false,
            customClass: 'modal-content',
            confirmButtonClass: 'btn btn-primary',
            cancelButtonClass: 'btn'
        })
    ],
    providers: [
        AppGlobals,
        TipoVehiculoService,
        VehiculosService,
        TroncalService,
        PortalService,
        EstacionService,
    ],
    exports: [RouterModule],
    bootstrap: [AppComponent]
})
export class AppModule {

}
