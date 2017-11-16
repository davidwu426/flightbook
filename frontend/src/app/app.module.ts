import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineDetailComponent } from './airline-detail/airline-detail.component';
import { AirlineService } from './services/airline/airline.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './services/message/message.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { OnewaySearchComponent } from './home/oneway-search/oneway-search.component';
import { RoundtripSearchComponent } from './home/roundtrip-search/roundtrip-search.component';
import { MulticitySearchComponent } from './home/multicity-search/multicity-search.component';

@NgModule({
  declarations: [
    AppComponent,
    AirlinesComponent,
    AirlineDetailComponent,
    MessagesComponent,
    HomeComponent,
    OnewaySearchComponent,
    RoundtripSearchComponent,
    MulticitySearchComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule.forRoot()
  ],
  providers: [
    AirlineService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
