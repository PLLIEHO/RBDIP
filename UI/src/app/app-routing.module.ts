import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { Path } from './common/path.constants';
import { MainMenuComponent } from './components/borderguard-portal/main-menu/main-menu.component';
import { OrdersListComponent } from './components/borderguard-portal/orders-list/orders-list.component';
import {CountryListComponent} from "./components/borderguard-portal/country-list/country-list.component";
import {JobListComponent} from "./components/borderguard-portal/job-list/job-list.component";
import {LuggageListComponent} from "./components/borderguard-portal/luggage-list/luggage-list.component";
import {CriminalListComponent} from "./components/borderguard-portal/criminal-list/criminal-list.component";
import {ReminderComponent} from "./components/borderguard-portal/reminder/reminder.component";

const routes: Routes = [
{path: Path.MainMenu, component: MainMenuComponent},
{path: Path.OrdersList, component: OrdersListComponent},
  {path: Path.CountryList, component: CountryListComponent},
  {path: Path.JobList, component: JobListComponent},
  {path: Path.LuggageList, component: LuggageListComponent},
  {path: Path.CriminalList, component: CriminalListComponent},
  {path: Path.Reminder, component: ReminderComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes,
    {
      preloadingStrategy: PreloadAllModules
    })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
