import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineDetailComponent } from './airline-detail/airline-detail.component';
import { HomeComponent } from './home/home.component';
import { SearchResultsComponent } from './search-results/search-results.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
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
