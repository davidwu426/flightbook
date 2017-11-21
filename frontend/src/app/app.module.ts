import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineDetailComponent } from './airline-detail/airline-detail.component';
import { AirlineService } from './services/airline/airline.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './services/message/message.service';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { OnewaySearchComponent } from './search/oneway-search/oneway-search.component';
import { RoundtripSearchComponent } from './search/roundtrip-search/roundtrip-search.component';
import { MulticitySearchComponent } from './search/multicity-search/multicity-search.component';
import { SearchComponent } from './search/search.component';
import { SearchService } from './services/search/search.service';
import { SearchResultsComponent } from './search-results/search-results.component';
import { SearchCondensedComponent } from './search-condensed/search-condensed.component';
import { OnewaySearchCondensedComponent } from './search-condensed/oneway-search-condensed/oneway-search-condensed.component';
import { MulticitySearchCondensedComponent } from './search-condensed/multicity-search-condensed/multicity-search-condensed.component';
import { RoundtripSearchCondensedComponent } from './search-condensed/roundtrip-search-condensed/roundtrip-search-condensed.component';
import { FlightResultsComponent } from './search-results/flight-results/flight-results.component';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { AuthService } from './services/auth/auth.service';
import { TokenIntercepter } from './auth/token-intercepter';
import { UserService } from './services/user/user.service';

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
    RegisterComponent
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
    MessageService,
    SearchService,
    AuthService,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenIntercepter,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
