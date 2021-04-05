import { NgModule } from '@angular/core';

import { ReservaRoutingModule } from './reserva-routing.module';
import { ReservaComponent } from './components/reserva/reserva.component';
import { EliminarComponent } from './components/eliminar/eliminar.component';
import { ListarComponent } from './components/listar/listar.component';
import { CrearComponent } from './components/crear/crear.component';
import { SharedModule } from '@shared/shared.module';
import { ReservaService } from './shared/service/reserva.service';




@NgModule({
  declarations: [
    CrearComponent,
    ListarComponent,
    EliminarComponent,
    ReservaComponent
  ],
  imports: [
    ReservaRoutingModule,
    SharedModule
  ],
  providers: [ReservaService]
})
export class ReservaModule { }
