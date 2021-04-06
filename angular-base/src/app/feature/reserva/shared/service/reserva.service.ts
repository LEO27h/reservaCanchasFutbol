import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Reserva } from '../model/reserva';

@Injectable()
export class ReservaService {
    
    constructor(protected http: HttpService) {}

    public listar() {
        alert(`${environment.endpoint}/reservas-canchas`)
        return this.http.doGet<Reserva[]>(`${environment.endpoint}/reservas-canchas`);
      }
    
      public crear(reserva: Reserva) {
        alert(reserva.idReserva + " " + reserva.idUsuario + " " + reserva.valorPagado + " " + reserva.fechaDeJuego 
        + " " + reserva.capacidadCancha + " " + reserva.pagoCompletado);
        alert("crear form service");
        return this.http.doPost<Reserva, boolean>(`${environment.endpoint}/reservas-canchas`, reserva);
      }
    
      public eliminar(reserva: Reserva) {
        return this.http.doDelete<boolean>(`${environment.endpoint}/reservas-canchas/${reserva.idReserva}`);
      }
      
    }
    