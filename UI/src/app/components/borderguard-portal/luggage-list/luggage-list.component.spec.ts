import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxSpinnerService } from 'ngx-spinner';
import { CrudService } from 'src/app/core/services/crud.service';
import { ErrorHandlerDescriptor } from 'src/app/core/services/error-handling/error-handler-descriptor';

import { LuggageListComponent } from './luggage-list.component';

describe('LuggageListComponent', () => {
  let component: LuggageListComponent;
  let fixture: ComponentFixture<LuggageListComponent>;

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
      imports: [HttpClientModule, RouterTestingModule, BrowserAnimationsModule],
      declarations: [ LuggageListComponent ],
      providers: [ {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: NgxSpinnerService, useValue: spinnerMock},
        CrudService,
        ErrorHandlerDescriptor]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LuggageListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
