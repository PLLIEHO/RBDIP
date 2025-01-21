import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/core/services/crud.service';
import {NgxSpinnerService} from "ngx-spinner";
import { ApiPath} from 'src/app/common/constants';
import { ActivatedRoute, Router } from '@angular/router';
import {LuggageModel} from "../../../models/luggage.model";

@Component({
  selector: 'app-luggage-list',
  templateUrl: './luggage-list.component.html',
  styleUrls: ['./luggage-list.component.scss']
})
export class LuggageListComponent implements OnInit {
  luggageCats: LuggageModel[];

  isProblem: boolean = false;

  constructor(private readonly route: ActivatedRoute,
    private readonly crudService: CrudService,
    private readonly router: Router,
    private spinner: NgxSpinnerService) {
     }

  async ngOnInit(): Promise<void> {
    try {
      this.spinner.show()
      this.luggageCats = await this.crudService.getAll<LuggageModel>(ApiPath.Luggage).toPromise();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }

}

