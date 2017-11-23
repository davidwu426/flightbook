import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineDetailComponent } from './airline-detail/airline-detail.component';
import { HomeComponent } from './home/home.component';
import { SearchResultsComponent } from './search-results/search-results.component';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { AuthGuard } from './auth/auth.guard';
import { AuthedGuard } from './auth/authed.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent, canActivate: [AuthedGuard] },
  { path: 'register', component: RegisterComponent, canActivate: [AuthedGuard] },
  { path: 'search-results', component: SearchResultsComponent },
  { path: 'airlines', component: AirlinesComponent },
  { path: 'detail/:id', component: AirlineDetailComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
