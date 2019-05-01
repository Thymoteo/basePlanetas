import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions, Response } from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/timeout";
import { Observable, Subject } from "rxjs";

const API_URL = "http://localhost:9000/basePlanetas/api/1.0.0/planeta";

@Injectable()
export class PlanetasService {

    constructor(
        private http: Http
      )  {}    

      public getPlanetas(): Promise<any> {
        return this.http.get(`${API_URL}/listar`)
            .toPromise()
            .then((resposta: Response) => resposta.json())
    }

    public getPlanetasHabitaveis(): Promise<any> {
        return this.http.get(`${API_URL}/listarHabitaveis`)
            .toPromise()
            .then((resposta: Response) => resposta.json())
    }

    public getPlanetasPorQuadrante(id: number): Promise<any> {
        return this.http.get(`${API_URL}/listarPlanetasPorQuadrante/${id}`)
            .toPromise()
            .then((resposta: Response) => resposta.json())
    }

    public getPlanetasPorClasse(id: string): Promise<any> {
        return this.http.get(`${API_URL}/listarPlanetasPorClasse/${id}`)
            .toPromise()
            .then((resposta: Response) => resposta.json())
    }

    public getPlanetasPorAtmosfera(id: number): Promise<any> {
        return this.http.get(`${API_URL}/listarPlanetasPorAtmosfera/${id}`)
            .toPromise()
            .then((resposta: Response) => resposta.json())
    }

}