import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './Components/home/home.component';
import { OppComponent } from './Components/home/opp/opp.component';
import { TrendsComponent } from './Components/home/trends/trends.component';
import { LoginComponent } from './Components/login/login.component';
import { GuardGuard } from './Guard/guard.guard';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'home',
    component: OppComponent,
    canActivate: [GuardGuard]
  },
  {
    path: 'trend',
    component: TrendsComponent,
    canActivate: [GuardGuard]
  },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
