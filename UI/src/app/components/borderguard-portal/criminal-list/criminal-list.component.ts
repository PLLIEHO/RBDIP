import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/core/services/crud.service';
import {NgxSpinnerService} from "ngx-spinner";
import { ApiPath } from 'src/app/common/constants';
import { ActivatedRoute, Router } from '@angular/router';


import {CriminalModel} from "../../../models/criminal.model";

@Component({
  selector: 'app-criminal-list',
  templateUrl: './criminal-list.component.html',
  styleUrls: ['./criminal-list.component.scss']
})
export class CriminalListComponent implements OnInit {
  criminals: CriminalModel[];

  isProblem: boolean = false;

  constructor(private readonly route: ActivatedRoute,
    private readonly crudService: CrudService,
    private readonly router: Router,
    private spinner: NgxSpinnerService) {
     }

  async ngOnInit(): Promise<void> {
    try {
      this.spinner.show()
      this.criminals = await this.crudService.getAll<CriminalModel>(ApiPath.Criminal).toPromise();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }

  getEyeColor(code: number){
    let colorstring = code.toString(16).toUpperCase();
    while (colorstring.length < 6){
      colorstring = 'F' + colorstring;
    }
    return '#' + colorstring;
  }

}

