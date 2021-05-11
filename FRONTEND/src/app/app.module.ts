import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OppComponent } from './Components/home/opp/opp.component';
import { TrendsComponent } from './Components/home/trends/trends.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import {
  SocialLoginModule,
  SocialAuthServiceConfig,
} from 'angularx-social-login';

import { GoogleLoginProvider } from 'angularx-social-login';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatMenuModule } from '@angular/material/menu';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSortModule } from '@angular/material/sort';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DeleteComponent } from './Components/DialogBox/delete/delete.component';
import { MatTreeModule } from '@angular/material/tree';
import { NavbarModule, WavesModule, ButtonsModule } from 'angular-bootstrap-md';
import { AddOppComponent } from './Components/DialogBox/add-opp/add-opp.component';
import { InterceptorInterceptor } from './Interceptor/interceptor.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { GoogleChartsModule } from 'angular-google-charts';
import { NgxChartsModule } from '@swimlane/ngx-charts';
@NgModule({
  declarations: [
    AppComponent,
    OppComponent,
    TrendsComponent,
    HomeComponent,
    LoginComponent,
    DeleteComponent,
    AddOppComponent
  ],
  imports: [
    BrowserAnimationsModule,
    NgxChartsModule,
    GoogleChartsModule,
    BrowserModule,
    AppRoutingModule,
    SocialLoginModule,
    HttpClientModule,
    MatMenuModule,
    MatGridListModule,
    MatSortModule,
    MatToolbarModule,
    ReactiveFormsModule,
    FormsModule,
    MatCardModule,
    MatTabsModule,
    MatSnackBarModule,
    MatIconModule,
    MatListModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatButtonModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatDialogModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatTreeModule,
    BrowserAnimationsModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatCardModule,
    NavbarModule,
    WavesModule,
    ButtonsModule,
    MatSnackBarModule,
    MatIconModule,
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '392131967384-nmvi802et1eskk2qp5a7kaf8f8egcfct.apps.googleusercontent.com'
            ),
          },
        ],
      } as SocialAuthServiceConfig,
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}
