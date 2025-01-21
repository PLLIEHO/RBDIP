import { LOCALE_ID, NgModule } from '@angular/core';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { BrowserModule } from '@angular/platform-browser';
import {NgxSpinnerModule} from "ngx-spinner";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CoreModule } from './core/core.module';
import { MainMenuComponent } from './components/borderguard-portal/main-menu/main-menu.component';
import { OrdersListComponent } from './components/borderguard-portal/orders-list/orders-list.component';
import { CountryListComponent } from './components/borderguard-portal/country-list/country-list.component';
import { NavMenuComponent } from './common/components/nav-menu/nav-menu.component';
import {MatRadioModule} from '@angular/material/radio';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import { OrdersListDialogComponent } from './components/dialogs/orders-list-dialog/orders-list-dialog.component';
import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import {MatNativeDateModule, DateAdapter} from '@angular/material/core';
import '@angular/common/locales/global/ru';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { ButtonDialogComponent } from './components/dialogs/button-dialog/button-dialog/button-dialog.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { SideMenuComponent } from './common/components/side-menu/side-menu/side-menu.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatMenuModule} from '@angular/material/menu';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatSortModule} from '@angular/material/sort';
import {JobListComponent} from "./components/borderguard-portal/job-list/job-list.component";
import {LuggageListComponent} from "./components/borderguard-portal/luggage-list/luggage-list.component";
import {CriminalListComponent} from "./components/borderguard-portal/criminal-list/criminal-list.component";
import {ReminderComponent} from "./components/borderguard-portal/reminder/reminder.component";

@NgModule({
  declarations: [
    AppComponent,
    MainMenuComponent,
    OrdersListComponent,
    CountryListComponent,
    JobListComponent,
    LuggageListComponent,
    CriminalListComponent,
    ReminderComponent,
    NavMenuComponent,
    OrdersListDialogComponent,
    ButtonDialogComponent,
    SideMenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgxSpinnerModule,
    BrowserAnimationsModule,
    CoreModule,
    MatRadioModule,
    FormsModule,
    MatButtonModule,
    MatDialogModule,
    MatDatepickerModule,
    MatCardModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatTooltipModule,
    BsDropdownModule.forRoot(),
    MatSidenavModule,
    MatMenuModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSortModule
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'ru-RU' },
    { provide: LOCALE_ID, useValue: 'ru' },
    {
      provide: MatDialogRef,
      useValue: {}
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
