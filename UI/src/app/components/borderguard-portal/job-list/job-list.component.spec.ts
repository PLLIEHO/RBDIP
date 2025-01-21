import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ActivatedRoute } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxSpinnerService } from 'ngx-spinner';
import { CrudService } from 'src/app/core/services/crud.service';
import { ErrorHandlerDescriptor } from 'src/app/core/services/error-handling/error-handler-descriptor';

import { JobListComponent } from './job-list.component';

describe('JobListComponent', () => {
  let component: JobListComponent;
  let fixture: ComponentFixture<JobListComponent>;

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
      declarations: [ JobListComponent ],
      providers: [ {provide: ActivatedRoute, useValue: fakeActivatedRoute},
        {provide: NgxSpinnerService, useValue: spinnerMock},
        CrudService,
        ErrorHandlerDescriptor]
    })
    .compileComponents();
    jasmine.DEFAULT_TIMEOUT_INTERVAL = 1000000;
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JobListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
