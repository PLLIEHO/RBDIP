import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import {Path} from "./common/path.constants";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {



  private subscription: Subscription = new Subscription();
  constructor(private readonly router: Router) {
  }

  ngOnInit() {

    this.router.navigate([Path.MainMenu, {replaceUrl: true}]);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
