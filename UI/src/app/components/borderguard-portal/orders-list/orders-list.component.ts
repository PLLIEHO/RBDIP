import {Component, OnInit} from '@angular/core';
import {CrudService} from 'src/app/core/services/crud.service';
import {NgxSpinnerService} from "ngx-spinner";
import {MatDialog} from '@angular/material/dialog';
import {OrdersListDialogComponent} from '../../dialogs/orders-list-dialog/orders-list-dialog.component';
import {ApiPath} from 'src/app/common/constants';
import {ActivatedRoute, Router} from '@angular/router';
import {PlanningVoyageDataIncoming} from 'src/app/models/planning-voyage-data-incoming.model';
import {PassportModel} from "../../../models/passport.model";
import {EntryPermissionModel} from "../../../models/entry-permission.model";
import {WorkPermissionModel} from "../../../models/work-permission.model";
import {DeclarationModel} from "../../../models/declaration.model";
import {ButtonDialogComponent} from "../../dialogs/button-dialog/button-dialog/button-dialog.component";

@Component({
  selector: 'app-orders-list',
  templateUrl: './orders-list.component.html',
  styleUrls: ['./orders-list.component.scss']
})
export class OrdersListComponent implements OnInit {

  order: PlanningVoyageDataIncoming;

  eyeColor: string;
  eyeColorPassport: string;
  luggageFlag: boolean = false;
  luggageCat: string;

  passport: PassportModel;
  entry: EntryPermissionModel;
  work: WorkPermissionModel;
  declaration: DeclarationModel;

  isProblem: boolean = false;


  constructor(private readonly route: ActivatedRoute,
    private readonly crudService: CrudService,
    private readonly router: Router,
    private spinner: NgxSpinnerService,
    public dialog: MatDialog) {
     }

  async ngOnInit(): Promise<void> {
    try {
      await this.uploadPvdData();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }

  async reload(): Promise<void> {
    try {
      window.location.reload();
      await this.uploadPvdData();
    }
    catch {
      this.isProblem = true;
    }
    finally {
      this.spinner.hide();
    }
  }


  async uploadPvdData() {
    this.spinner.show();
    this.order = await this.crudService.getOne<PlanningVoyageDataIncoming>(ApiPath.PlanningVoyageData).toPromise();
    await this.checkLuggage(this.order);
    console.log(this.order)
    this.eyeColor = this.getEyeColor(this.order.eyeColor);
    this.eyeColorPassport = this.getEyeColor(this.order.pseyeColor);
    this.mapToPassport(this.order);
    await this.mapToEntry(this.order);
    await this.mapToWorkPermission(this.order);
    await this.mapToDeclaration(this.order)
  }

  mapToPassport(entity: PlanningVoyageDataIncoming){
    this.passport = {
      eyeColor: entity.pseyeColor,
      name: entity.psname,
      surname: entity.surname,
      lastname: entity.lastname,
      nationality: entity.nationality
    };
  }

  async checkLuggage(entity: PlanningVoyageDataIncoming){
    if(entity.lugsize != null && entity.lugweight != null && entity.lugcategory != null){
      this.luggageFlag = true;

      this.luggageCat = entity.lugcategory;
    }
  }


  async mapToDeclaration(entity: PlanningVoyageDataIncoming){
    if(entity.decname == null && entity.decsurname == null && entity.declastname == null && entity.decsize == null && entity.decweight == null && entity.deccat == null){
      this.declaration = null;
    }
    else {
      this.declaration = {
        name: entity.enname,
        surname: entity.ensurname,
        lastname: entity.enlastname,
        category: entity.deccat,
        weight: entity.decweight,
        size: entity.decsize
      };
    }
  }

  async mapToEntry(entity: PlanningVoyageDataIncoming){
    if(entity.enname == null && entity.ensurname == null && entity.enlastname == null && entity.endateGaned == null && entity.endateExpired == null && entity.enpurpose == null){
      this.entry = null;
    }
    else {
      this.entry = {
        name: entity.enname,
        surname: entity.ensurname,
        lastname: entity.enlastname,
        purpose: entity.enpurpose,
        dateGained: entity.endateGaned,
        dateExpired: entity.endateExpired
      };
    }
  }

  async mapToWorkPermission(entity: PlanningVoyageDataIncoming){
    if(entity.workname == null && entity.worksurname == null && entity.worklastname == null && entity.workcompany == null){
      this.work = null;
    }
    else {
      this.work = {
        name: entity.workname,
        surname: entity.worksurname,
        lastname: entity.worklastname,
        company: entity.workcompany
      };
    }
  }

  getEyeColor(code: number){
    let colorstring = code.toString(16).toUpperCase();
    while (colorstring.length < 6){
      colorstring = 'F' + colorstring;
    }
    return '#' + colorstring;
  }

  async dialogFunction(){
    const dialogRef2 = this.dialog.open(ButtonDialogComponent, {width: '600px'});
    dialogRef2.afterClosed().subscribe(async ans => {
      await this.crudService.getOneText<string>(ApiPath.Decline).toPromise();
      try {
        this.spinner.show();
        this.order = await this.crudService.getOne<PlanningVoyageDataIncoming>(ApiPath.PlanningVoyageData).toPromise();
        await this.checkLuggage(this.order);
        console.log(this.order)
        this.eyeColor = this.getEyeColor(this.order.eyeColor);
        this.eyeColorPassport = this.getEyeColor(this.order.pseyeColor);
        this.mapToPassport(this.order);
        await this.mapToEntry(this.order);
        await this.mapToWorkPermission(this.order);
        await this.mapToDeclaration(this.order)
      }
      catch {
        this.isProblem = true;
      }
      finally {
        this.spinner.hide();
      }
    })
  }

  async allow(){
    await this.dialogFunction();
  }

  async decline(): Promise<void> {
    try {
        const dialogRef = this.dialog.open(OrdersListDialogComponent, {
          width: '250px'});
        dialogRef.afterClosed().subscribe(async result => {
          if (result) {
            await this.dialogFunction();

            return;
          }
          else {
            return;
          }
        });
      }

    catch {
      console.log("Ошибка при открытии диалогового окна")
    }
  }

}

