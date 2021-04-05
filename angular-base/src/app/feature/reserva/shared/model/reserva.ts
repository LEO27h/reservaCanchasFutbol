export class Reserva {
    idReserva: string;
    idUsuario: string;
    valorPagado: string;
    fechaDeJuego: string;
    capcacidadCancha: string;
    pagoCompletado: string;

    constructor(idReserva: string, idUsuario: string, valorPagado: string, 
        fechaDejuego: string, capacidadCancha: string, pagoCompletado: string){
            this.idReserva = idReserva;
            this.idUsuario = idUsuario;
            this.valorPagado = valorPagado;
            this.fechaDeJuego = fechaDejuego;
            this.capcacidadCancha = capacidadCancha;
            this.pagoCompletado = pagoCompletado;
        }
}