import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Reserva } from '../model/reserva';

@Injectable()
export class ReservaService {
    
    constructor(protected http: HttpService) {}

    public listar() {
        return this.http.doGet<Reserva[]>(`${environment.endpoint}/api`, this.http.optsName('reservas-canchas'));
      }
    
      public crear(reserva: Reserva) {
        return this.http.doPost<Reserva, boolean>(`${environment.endpoint}/api`, reserva,
                                                    this.http.optsName('reservas-canchas'));
      }
    
      public eliminar(reserva: Reserva) {
        return this.http.doDelete<boolean>(`${environment.endpoint}/api/${reserva.idReserva}`,
                                                     this.http.optsName('reservas-canchas'));
      }
      
    }
    