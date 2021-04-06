import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Reserva } from '../../shared/model/reserva';
import { ReservaService } from './../../shared/service/reserva.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  public listaReservas: Observable<Reserva[]>;

  constructor(protected reservaService: ReservaService) { }

  ngOnInit(): void {
    this.listaReservas = this.reservaService.listar();
  }

}
