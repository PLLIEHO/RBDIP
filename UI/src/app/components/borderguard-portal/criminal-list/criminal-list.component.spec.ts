import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxSpinnerService } from 'ngx-spinner';
import { CrudService } from 'src/app/core/services/crud.service';
import { ErrorHandlerDescriptor } from 'src/app/core/services/error-handling/error-handler-descriptor';

import { CriminalListComponent } from './criminal-list.component';

describe('CriminalListComponent', () => {
  let component: CriminalListComponent;
  let fixture: ComponentFixture<CriminalListComponent>;

  const fakeActivatedRoute = {
    snapshot : {
    }
  } as ActivatedRoute;

  const spinnerMock = {
    hide: () => { },
    show: () => { }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientModule, RouterTestingModule],
      declarations: [ CriminalListComponent ],
      providers: [ {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: NgxSpinnerService, useValue: spinnerMock},
        CrudService,
        ErrorHandlerDescriptor]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CriminalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
