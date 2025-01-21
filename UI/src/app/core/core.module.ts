import { ErrorHandlerDescriptor } from './services/error-handling/error-handler-descriptor';
import { ErrorHandlerService } from './services/error-handling/error-handler.service';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { CrudService } from './services/crud.service';

@NgModule({
    imports: [
        HttpClientModule
    ],
    exports: [],
    declarations: [],
    providers: [
        ErrorHandlerService,
        ErrorHandlerDescriptor,
        CrudService
    ],
})
export class CoreModule { }
