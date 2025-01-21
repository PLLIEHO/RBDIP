import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/core/services/crud.service';
import {NgxSpinnerService} from "ngx-spinner";
import { ApiPath } from 'src/app/common/constants';
import { ActivatedRoute, Router } from '@angular/router';


import {JobModel} from "../../../models/job.model";


@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss']
})
export class JobListComponent implements OnInit {
  jobs: JobModel[];

  isProblem: boolean = false;

  constructor(private readonly route: ActivatedRoute,
    private readonly crudService: CrudService,
    private readonly router: Router,
    private spinner: NgxSpinnerService) {
     }

  async ngOnInit(): Promise<void> {
    try {
      this.spinner.show()
      this.jobs = await this.crudService.getAll<JobModel>(ApiPath.Job).toPromise();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }

}

