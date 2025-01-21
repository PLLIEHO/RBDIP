import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/core/services/crud.service';
import {NgxSpinnerService} from "ngx-spinner";
import { ApiPath} from 'src/app/common/constants';
import { ActivatedRoute, Router } from '@angular/router';

import {CountryModelModel} from "../../../models/country.model";

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.scss']
})
export class CountryListComponent implements OnInit {
  countries: CountryModelModel[];

  isProblem: boolean = false;

  constructor(private readonly route: ActivatedRoute,
    private readonly crudService: CrudService,
    private readonly router: Router,
    private spinner: NgxSpinnerService) {
     }

  async ngOnInit(): Promise<void> {
    try {
      this.spinner.show()
      this.countries = await this.crudService.getAll<CountryModelModel>(ApiPath.Country).toPromise();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }

}

