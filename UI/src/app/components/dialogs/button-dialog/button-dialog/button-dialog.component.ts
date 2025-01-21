import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import {ValidationModel} from "../../../../models/validation-model.model";
import {ApiPath} from "../../../../common/constants";
import {CrudService} from "../../../../core/services/crud.service";

@Component({
  selector: 'app-button-dialog',
  templateUrl: './button-dialog.component.html',
  styleUrls: ['./button-dialog.component.scss']
})
export class ButtonDialogComponent implements OnInit {

  validation: ValidationModel;

  constructor(public dialogRef: MatDialogRef<ButtonDialogComponent>, private readonly crudService: CrudService) {
  }

  async ngOnInit(): Promise<void> {
    this.validation = await this.crudService.getOne<ValidationModel>(ApiPath.Validate).toPromise();
  }

  reload() {
    this.dialogRef.close();
  }
}
