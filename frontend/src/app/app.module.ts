import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LaddaModule } from 'angular2-ladda';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NotificationComponent } from './notification/notification.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { SearchComponent } from './search/search.component';
import { OnewaySearchComponent } from './search/oneway-search/oneway-search.component';
import { RoundtripSearchComponent } from './search/roundtrip-search/roundtrip-search.component';
import { MulticitySearchComponent } from './search/multicity-search/multicity-search.component';
import { SearchCondensedComponent } from './search-condensed/search-condensed.component';
import { OnewaySearchCondensedComponent } from './search-condensed/oneway-search-condensed/oneway-search-condensed.component';
import { MulticitySearchCondensedComponent } from './search-condensed/multicity-search-condensed/multicity-search-condensed.component';
import { RoundtripSearchCondensedComponent } from './search-condensed/roundtrip-search-condensed/roundtrip-search-condensed.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { FlightResultsComponent } from './search-results/flight-results/flight-results.component';
import { MessagesComponent } from './messages/messages.component';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineDetailComponent } from './airline-detail/airline-detail.component';

import { AuthService } from './services/auth/auth.service';
import { UserService } from './services/user/user.service';
import { SearchService } from './services/search/search.service';
import { NotificationService } from './services/notification/notification.service';
import { AirlineService } from './services/airline/airline.service';
import { AirportService } from './services/airport/airport.service';
import { MessageService } from './services/message/message.service';

import { TokenInterceptor } from './auth/token.interceptor';

import { AuthGuard } from './auth/auth.guard';
import { AuthedGuard } from './auth/authed.guard';

@NgModule({
  declarations: [
    AppComponent,
    AirlinesComponent,
    AirlineDetailComponent,
    MessagesComponent,
    HomeComponent,
    OnewaySearchComponent,
    RoundtripSearchComponent,
    MulticitySearchComponent,
    SearchComponent,
    SearchResultsComponent,
    SearchCondensedComponent,
    OnewaySearchCondensedComponent,
    MulticitySearchCondensedComponent,
    RoundtripSearchCondensedComponent,
    FlightResultsComponent,
    LoginComponent,
    RegisterComponent,
    NotificationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule.forRoot(),
    BrowserAnimationsModule,
    LaddaModule
  ],
  providers: [
    AirlineService,
    AirportService,
    MessageService,
    SearchService,
    AuthService,
    AuthGuard,
    AuthedGuard,
    NotificationService,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
