import { Component, OnInit } from '@angular/core';
import { ReservaService } from './../../shared/service/reserva.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Reserva } from './../../shared/model/reserva';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css']
})
export class CrearComponent implements OnInit {
  reservaForm: FormGroup;
  reserva:  Reserva = new Reserva();

  constructor(protected reservaServices: ReservaService) { }

  ngOnInit(): void {
    this.construirFormularioReserva();
  }

  // crear() {
  //   alert("crear method");
  //   this.reservaServices.crear(this.reservaForm.value);
  // }

  
  crear(reserva: Reserva){
    alert(reserva.idUsuario);
    reserva.fechaDeJuego = reserva.fechaDeJuego.replace("T", " ");
    reserva.fechaDeJuego = reserva.fechaDeJuego.concat(":00");
    this.reservaServices.crear(reserva).subscribe(data => {
      console.log(data);
      // this.routes.navigate(['listar']);
    })
  }

  private construirFormularioReserva() {
    this.reservaForm = new FormGroup({
      idUsuario: new FormControl('', [Validators.required]),
      valorPagado: new FormControl('', [Validators.required]),
      fechaDeJuego: new FormControl('', [Validators.required]),
      capacidadCancha: new FormControl('', [Validators.required])
    });
  }
}
