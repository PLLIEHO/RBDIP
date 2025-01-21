import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Path } from 'src/app/common/path.constants';
import { CrudService } from 'src/app/core/services/crud.service';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.scss']
})
export class SideMenuComponent implements OnInit {


  constructor(private readonly crudService: CrudService,
    private readonly router: Router) {
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
     }

  async ngOnInit(): Promise<void> {

  }

  goClients() {
    this.router.navigate([Path.OrdersList]);
  }

  goCountry() {
    this.router.navigate([Path.CountryList]);
  }

  goJobs() {
    this.router.navigate([Path.JobList]);
  }

  goLuggage() {
    this.router.navigate([Path.LuggageList]);
  }

  goCriminal() {
    this.router.navigate([Path.CriminalList]);
  }

  goReminder() {
    this.router.navigate([Path.Reminder]);
  }

}
