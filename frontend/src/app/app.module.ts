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
import { FlightService } from './services/flight/flight.service';
import { LegService } from './services/leg/leg.service';
import { EmployeeService } from './services/employee/employee.service';
import { ManagerService } from './services/manager/manager.service';
import { CustomerService } from './services/customer/customer.service';
import { PersonService } from './services/person/person.service';
import { ReservationService } from './services/reservation/reservation.service';

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
import { AirlineCardComponent } from './dashboard/cards/airline-card/airline-card.component';
import { AirportCardComponent } from './dashboard/cards/airport-card/airport-card.component';
import { FlightCardComponent } from './dashboard/cards/flight-card/flight-card.component';
import { LegTableComponent } from './dashboard/cards/flight-card/leg-table/leg-table.component';
import { AirportSelectComponent } from './airport-select/airport-select.component';
import { UserCardComponent } from './dashboard/cards/user-card/user-card.component';
import { EmployeeCardComponent } from './dashboard/cards/employee-card/employee-card.component';
import { ManagerCardComponent } from './dashboard/cards/manager-card/manager-card.component';
import { CustomerCardComponent } from './dashboard/cards/customer-card/customer-card.component';
import { PersonInfoEditComponent } from './dashboard/cards/person-info-edit/person-info-edit.component';
import { ReservationCardComponent } from './dashboard/cards/reservation-card/reservation-card.component';
import { IncludesTableComponent } from './dashboard/cards/reservation-card/includes-table/includes-table.component';
import { CustomerReservationCardComponent } from './dashboard/cards/reservation-card/customer-reservation-card/customer-reservation-card.component';
import { ContactsCardComponent } from './dashboard/cards/contacts-card/contacts-card.component';
import { SuggestionsCardComponent } from './dashboard/cards/suggestions-card/suggestions-card.component';
import { CustomerSuggestionsCardComponent } from './dashboard/cards/customer-suggestions-card/customer-suggestions-card.component';
import { RevenueCardComponent } from './dashboard/cards/revenue-card/revenue-card.component';
import { RevenueService } from './services/revenue/revenue.service';
import { FlightsByAirportCardComponent } from './dashboard/cards/flights-by-airport-card/flights-by-airport-card.component';
import { RevenueByCustomerRepCardComponent } from './dashboard/cards/revenue-by-customer-rep-card/revenue-by-customer-rep-card.component';
import { RevenueByCustomerCardComponent } from './dashboard/cards/revenue-by-customer-card/revenue-by-customer-card.component';
import { OnewaySearchEntryComponent } from './search-results/flight-results/oneway-search-entry/oneway-search-entry.component';
import { AuctionCardComponent } from './dashboard/cards/auction-card/auction-card.component';
import { CustomerAuctionsCardComponent } from './dashboard/cards/customer-auctions-card/customer-auctions-card.component';
import { MostFrequentFlightCardComponent } from './dashboard/cards/most-frequent-flight-card/most-frequent-flight-card.component';
import { OnTimeFlightCardComponent } from './dashboard/cards/on-time-flight-card/on-time-flight-card.component';
import { CustomerOnFlightCardComponent } from './dashboard/cards/customer-on-flight-card/customer-on-flight-card.component';
import { HelpMenuComponent } from './help-menu/help-menu.component';

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
    AirportCardComponent,
    FlightCardComponent,
    LegTableComponent,
    AirportSelectComponent,
    UserCardComponent,
    EmployeeCardComponent,
    ManagerCardComponent,
    CustomerCardComponent,
    PersonInfoEditComponent,
    ReservationCardComponent,
    IncludesTableComponent,
    CustomerReservationCardComponent,
    ContactsCardComponent,
    SuggestionsCardComponent,
    CustomerSuggestionsCardComponent,
    RevenueCardComponent,
    CustomerOnFlightCardComponent,
    OnewaySearchEntryComponent, 
    FlightsByAirportCardComponent,
    RevenueByCustomerRepCardComponent,
    RevenueByCustomerCardComponent,
    CustomerAuctionsCardComponent,
    AuctionCardComponent,
    MostFrequentFlightCardComponent,
    OnTimeFlightCardComponent,
    HelpMenuComponent
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
    FlightService,
    LegService,
    MessageService,
    SearchService,
    AuthService,
    AuthGuard,
    AuthedGuard,
    NotificationService,
    UserService,
    EmployeeService,
    ManagerService,
    CustomerService,
    PersonService,
    ReservationService,
    RevenueService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
