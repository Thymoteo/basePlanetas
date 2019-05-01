import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';
import { HttpModule } from '@angular/http'
import { ReactiveFormsModule } from '@angular/forms'

import localePt from "@angular/common/locales/pt";
import { registerLocaleData } from '@angular/common';
registerLocaleData(localePt);

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';

import { PlanetasService } from './planetas.service'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ReactiveFormsModule
  ],
  providers: [PlanetasService, {provide: LOCALE_ID, useValue: 'pt'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
