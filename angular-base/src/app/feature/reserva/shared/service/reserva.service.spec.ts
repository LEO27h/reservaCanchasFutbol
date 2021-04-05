import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ReservaService } from './reserva.service';
import { environment } from 'src/environments/environment';
import { HttpService} from 'src/app/core/services/http.service';
import { Reserva } from "../model/reserva";
import { HttpResponse } from "@angular/common/http";

describe('ReservaService', () => {
    let httpMock: HttpTestingController;
    let service: ReservaService;
    const apiEndPointReservaConsulta = `${environment.endpoint}/api`;

    beforeEach(() => {
        const injector = TestBed.configureTestingModule({
          imports: [HttpClientTestingModule],
          providers: [ReservaService, HttpService]
        });
        httpMock = injector.inject(HttpTestingController);
        service = TestBed.inject(ReservaService);
      });
    
});


