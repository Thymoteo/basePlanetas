import { Component, OnInit } from '@angular/core';
import { PlanetasService } from '../planetas.service'
import { FormGroup, FormControl, Validators, FormControlDirective, FormsModule } from '@angular/forms';

import * as moment from 'moment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public formulario: FormGroup = new FormGroup({
    'tipoLista': new FormControl(0),
    'listaQuadrantes': new FormControl(0),
    'listaClasses': new FormControl(0),
    'listaAtmosferas': new FormControl(0)
  })

  public modalForm: FormGroup = new FormGroup({
    'descobrimento': new FormControl(null),
    'massa': new FormControl(null),
    'diametro': new FormControl(null),
    'colonizado': new FormControl(null),
    'quadrante': new FormControl(null),
    'classe': new FormControl(null),
    'atmosfera': new FormControl(null)
  })

  constructor(
    public planetasService: PlanetasService
  ) { }

  planetas = []

  planetaSelecionado = {
    nome: null,
    idPlaneta: 0,
    massa: 0,
    diametro: 0,
    planetaColonizado: null,
    dataDescobrimento: null,
    classePlaneta: {descricao: '', idClasse: ''},
    tipoAtomosfera: {descricao: '', idTipoAtmosfera: 0},
    quadrante: {descricao: '', idQuadrante: 0} 
  }

  tipoListagem = [
    {codigo: 1, descricao: "Todos"},
    {codigo: 2, descricao: "Habitáveis"}
  ]

  listaQuadrantes = [
    {codigo: 1, descricao: "Alfa"},
    {codigo: 2, descricao: "Beta"},
    {codigo: 3, descricao: "Gama"},
    {codigo: 4, descricao: "Delta"}
  ]

  listaClasses = [
    {codigo: "A", descricao: "Gigante Gasoso"},
    {codigo: "B", descricao: "Sulfúrico"},
    {codigo: "C", descricao: "Tóxico"},
    {codigo: "D", descricao: "Habitável"}
  ]

  listaAtmosferas = [
    {codigo: "1", descricao: "Oxigênio"},
    {codigo: "2", descricao: "Metano"},
    {codigo: "3", descricao: "Hidrogênio"}
  ]

  ngOnInit() {
  
  }

  consultaGeral(tipo) {

    if(tipo == 1) {

      this.planetasService.getPlanetas()
      .then((res) => {
        this.planetas = res
        console.log(this.planetas)
      })
      .catch((err) => {
        console.log(err)
      })

    } else if (tipo == 2) {

      this.planetasService.getPlanetasHabitaveis()
      .then((res) => {
        this.planetas = res
        console.log(this.planetas)
      })
      .catch((err) => {
        console.log(err)
      })

    }

  }

  consultaPorQuadrante(quadrante) {
    
    this.planetasService.getPlanetasPorQuadrante(quadrante)
      .then((res) => {
        this.planetas = res
        console.log(this.planetas)
      })
      .catch((err) => {
        console.log(err)
      })

  }

  consultaPorClasse(classe) {
    
    this.planetasService.getPlanetasPorClasse(classe)
      .then((res) => {
        this.planetas = res
        console.log(this.planetas)
      })
      .catch((err) => {
        console.log(err)
      })

  }

  consultaPorAtmosfera(atmosfera) {
    
    this.planetasService.getPlanetasPorAtmosfera(atmosfera)
      .then((res) => {
        this.planetas = res
        console.log(this.planetas)
      })
      .catch((err) => {
        console.log(err)
      })

  }

  selecionaModal(planeta) {
    this.planetaSelecionado = planeta;

    // let date = moment(planeta.dataDescobrimento).format('DD/MM/YYYY')
    // this.planetaSelecionado.dataDescobrimento = date
    // console.log(moment(planeta.dataDescobrimento).format('DD/MM/YYYY'))
  
  }

  salvarPlaneta(planeta) {
    console.log(planeta)
  }

}
