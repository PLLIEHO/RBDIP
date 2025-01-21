import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxSpinnerService } from 'ngx-spinner';
import { CrudService } from 'src/app/core/services/crud.service';
import { ErrorHandlerDescriptor } from 'src/app/core/services/error-handling/error-handler-descriptor';

import { CountryListComponent } from './country-list.component';

describe('CountryListComponent', () => {
  let component: CountryListComponent;
  let fixture: ComponentFixture<CountryListComponent>;

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
      declarations: [ CountryListComponent ],
      providers: [ {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: NgxSpinnerService, useValue: spinnerMock},
        CrudService,
        ErrorHandlerDescriptor]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CountryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
