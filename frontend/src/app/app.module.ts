import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { LaddaModule } from 'angular2-ladda';

import { AppRoutingModule } from './app-routing.module';

import { TokenInterceptor } from './auth/token.interceptor';

import { AuthGuard } from './auth/auth.guard';
import { AuthedGuard } from './auth/authed.guard';

import { AuthService } from './services/auth/auth.service';
import { UserService } from './services/user/user.service';
import { SearchService } from './services/search/search.service';
import { NotificationService } from './services/notification/notification.service';
import { AirlineService } from './services/airline/airline.service';
import { AirportService } from './services/airport/airport.service';
import { MessageService } from './services/message/message.service';

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
import { ProfileComponent } from './profile/profile.component';
import { ProfileInformationManagerComponent } from './profile/profile-information-manager/profile-information-manager.component';
import { ProfileInformationEmployeeComponent } from './profile/profile-information-employee/profile-information-employee.component';
import { ProfileInformationCustomerComponent } from './profile/profile-information-customer/profile-information-customer.component';
import { ProfileInformationAdminComponent } from './profile/profile-information-admin/profile-information-admin.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DashboardCustomerComponent } from './dashboard/dashboard-customer/dashboard-customer.component';
import { DashboardEmployeeComponent } from './dashboard/dashboard-employee/dashboard-employee.component';
import { DashboardManagerComponent } from './dashboard/dashboard-manager/dashboard-manager.component';
import { DashboardAdminComponent } from './dashboard/dashboard-admin/dashboard-admin.component';
import { AirlineCardComponent } from './dashboard/airline-card/airline-card.component';
import { AirportCardComponent } from './dashboard/airport-card/airport-card.component';

@NgModule({
  declarations: [
    AppComponent,
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
    NotificationComponent,
    ProfileComponent,
    ProfileInformationManagerComponent,
    ProfileInformationEmployeeComponent,
    ProfileInformationCustomerComponent,
    ProfileInformationAdminComponent,
    DashboardComponent,
    DashboardCustomerComponent,
    DashboardEmployeeComponent,
    DashboardManagerComponent,
    DashboardAdminComponent,
    AirlineCardComponent,
    AirportCardComponent
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
