import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ApiPath} from "../../../common/constants";
import {CrudService} from "../../../core/services/crud.service";
import {NgxSpinnerService} from "ngx-spinner";
import {InstructionModel} from "../../../models/instruction.model";

@Component({
  selector: 'app-main-menu',
  templateUrl: './main-menu.component.html',
  styleUrls: ['./main-menu.component.scss']
})
export class MainMenuComponent implements OnInit {
  instructions: InstructionModel[];

  isProblem: boolean = false;

  constructor(private readonly route: ActivatedRoute,
              private readonly crudService: CrudService,
              private readonly router: Router,
              private spinner: NgxSpinnerService) {

  }

  async ngOnInit(): Promise<void> {
    try {
      this.spinner.show()
      this.instructions = await this.crudService.getAll<InstructionModel>(ApiPath.Instruction).toPromise();
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
