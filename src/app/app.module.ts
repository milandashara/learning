import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import {FormsModule} from "@angular/forms";
import {RecordsService} from "./records.service";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import { DataComponent } from './data/data.component';
import {RouterModule} from "@angular/router";
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import {AuthGuard} from "./auth.guard";
import { ReversepipePipe } from './reversepipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    HomeComponent,
    DataComponent,
    LoginComponent,
    AdminComponent,
    ReversepipePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(
      [
        {
          path: 'data',
          component: DataComponent
        },
        {
          path: 'login',
          component: LoginComponent
        },
        {
          path: 'admin',
          component: AdminComponent,
          canActivate: [AuthGuard]
        },
      {
        path: '',
        component: HomeComponent
      },

      ]
    )
  ],
  providers: [RecordsService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
