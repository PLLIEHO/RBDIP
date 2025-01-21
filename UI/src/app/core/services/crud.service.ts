import { HttpClient, HttpHeaders, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { catchError } from "rxjs/operators";
import { HttpMethod } from "../utils/http-method";
import { ErrorHandlerService } from "./error-handling/error-handler.service";

@Injectable({
    providedIn: 'root'
})
export class CrudService {
    constructor(
        protected readonly httpClient: HttpClient,
        protected readonly errorHandlerService: ErrorHandlerService
    ) {
    }

    getAll<T>(apiUrl: string): Observable<Array<T>> {
        return this.httpClient
            .get<Array<T>>(this.getAbsoluteUrl(apiUrl))
            .pipe(catchError(this.getErrorHandler<Array<T>>('get', apiUrl)));
    }

    getOne<T>(apiUrl: string): Observable<T> {
        return this.httpClient
            .get<T>(this.getAbsoluteUrl(apiUrl))
            .pipe(
                catchError(this.getErrorHandler('get', apiUrl))
            );
    }

  getOneText<T>(apiUrl: string): Observable<T> {
    return this.httpClient
      .get(this.getAbsoluteUrl(apiUrl), {
        responseType: 'text'
      })
      .pipe(
        catchError(this.getErrorHandler('get', apiUrl))
      );
  }

    add<TIn, TOut>(apiUrl: string, item: TIn): Observable<TOut> {
        return this.httpClient
            .post<TIn>(this.getAbsoluteUrl(apiUrl), item)
            .pipe(catchError(this.getErrorHandler('post', apiUrl)));
    }



    update<T>(apiUrl: string, item: T, id?: number | string): Observable<T> {
        return this.httpClient
            .put<T>(this.getAbsoluteUrl(apiUrl, id), item)
            .pipe(catchError(this.getErrorHandler('put', apiUrl)));
    }


    protected getErrorHandler<T>(method: HttpMethod, apiUrl: string, result?: T)
    : (error: any | HttpResponse<T>) => Observable<any> {
    return (error: any | HttpResponse<T>) => {
        if (error instanceof HttpResponse) {
            this.errorHandlerService.handle(error.status, method, apiUrl);
        }

        throw result || error;
    };
}

    protected getAbsoluteUrl(apiUrl: string, id?: number|string): string {
        return `${apiUrl}${id ? '/' + id : ''}`;
    }
}
