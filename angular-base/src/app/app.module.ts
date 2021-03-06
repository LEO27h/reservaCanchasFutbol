import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from '@home/home.component';
import { ProductoModule } from '@producto/producto.module';
import { ReservaModule } from "./feature/reserva/reserva.module";
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { ReservaService } from './feature/reserva/shared/service/reserva.service';
import { HttpClientModule } from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProductoModule,
    ReservaModule,
    CoreModule,
    HttpClientModule
  ],
  providers: [CookieService, ReservaService],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
