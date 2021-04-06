package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoAbonoReserva;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/reservas-canchas")
@Api(tags = { "Controlador comando reserva"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
    private final ManejadorActualizarReserva manejadorActualizarReserva;
    private final ManejadorEliminarReserva manejadorEliminarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva, ManejadorActualizarReserva manejadorActualizarReserva, ManejadorEliminarReserva manejadorEliminarReserva) {
        this.manejadorCrearReserva = manejadorCrearReserva;
        this.manejadorActualizarReserva = manejadorActualizarReserva;
        this.manejadorEliminarReserva = manejadorEliminarReserva;
    }

    @PostMapping
    @ApiOperation("Crear reserva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value="/{idReserva}")
    @ApiOperation("Eliminar reserva")
    public void eliminar(@PathVariable Long idReserva) {
        manejadorEliminarReserva.ejecutar(idReserva);
    }

    @PutMapping(value="/{idReserva}")
    @ApiOperation("Actualizar reserva")
    public void actualizar(@RequestBody ComandoAbonoReserva comandoAbonoReserva, @PathVariable Long idReserva) {
        manejadorActualizarReserva.ejecutar(comandoAbonoReserva, idReserva);
    }
}
