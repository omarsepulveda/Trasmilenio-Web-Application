import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import { IndexComponent } from './components/index/index.component';
import {RouterModule, Routes} from '@angular/router';
import { VehiculosComponent } from './components/vehiculos/vehiculos.component';
import { TroncalesComponent } from './components/troncales/troncales.component';
import { PortalesComponent } from './components/portales/portales.component';
import {HttpClientModule} from '@angular/common/http';

const appRoutes: Routes = [
    {path: '', component: IndexComponent},
    {path: 'vehiculos', component: VehiculosComponent},
    {path: 'troncales', component: TroncalesComponent},
    {path: 'portales', component: PortalesComponent}
];
@NgModule({
    declarations: [
        AppComponent,
        IndexComponent,
        VehiculosComponent,
        TroncalesComponent,
        PortalesComponent
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(appRoutes, {initialNavigation: 'enabled'}),
        MDBBootstrapModule.forRoot(),
        HttpClientModule
    ],
    providers: [],
    exports: [RouterModule],
    bootstrap: [AppComponent]
})
export class AppModule {

}
