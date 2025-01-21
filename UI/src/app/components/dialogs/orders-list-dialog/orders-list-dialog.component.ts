import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogData } from 'src/app/models/dialog-data.model';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-orders-list-dialog',
  templateUrl: './orders-list-dialog.component.html',
  styleUrls: ['./orders-list-dialog.component.scss']
})
export class OrdersListDialogComponent implements OnInit {
  reasons = new FormControl('');
  reasonList: string[] = ['Ошибка в паспорте', 'Ошибка в разрешении на въезд', 'Ошибка в разрешении на работу', 'Ошибка в декларации', 'Недопустимый багаж', 'Закончились рабочие места', 'Границы со страной закрыты', 'Подозрительная личность', 'Несколько'];
  chosenReason: string;

  constructor( public dialogRef: MatDialogRef<OrdersListDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) { }

  ngOnInit(): void {
  }

  ok() {
    this.dialogRef.close(this.chosenReason);
  }

  notOk() {
    this.dialogRef.close(false);
  }

}
