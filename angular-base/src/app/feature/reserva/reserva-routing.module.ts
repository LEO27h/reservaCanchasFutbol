import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearComponent } from './components/crear/crear.component';
import { ListarComponent } from './components/listar/listar.component';
import { EliminarComponent } from './components/eliminar/eliminar.component';
import { ReservaComponent } from './components/reserva/reserva.component';

const routes: Routes = [
    {
      path: '',
      component: ReservaComponent,
      children: [
        {
          path: 'crear',
          component: CrearComponent
        },
        {
          path: 'listar',
          component: ListarComponent
        },
        {
          path: 'borrar',
          component: EliminarComponent
        }
      ]
    }
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class ReservaRoutingModule { }
  