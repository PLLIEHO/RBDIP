import {Injectable, Inject} from '@angular/core';
import {HttpMethod} from '../../utils/http-method';
import { ErrorHandlerDescriptor } from './error-handler-descriptor';

@Injectable({
    providedIn: 'root'
})
export class ErrorHandlerService {
    constructor(
        @Inject(ErrorHandlerDescriptor) private readonly handlers: Array<ErrorHandlerDescriptor>
    ) {
    }

    handle(httpErrorCode: number, httpMethod: HttpMethod, apiRoute: string) {
        const handlers = this.handlers.filter(h => {
            return (!h.httpErrorCode || h.httpErrorCode === httpErrorCode)
                && (!h.httpMethod || h.httpMethod === httpMethod)
                && this.getIsApiRouteMatch(h.apiRoute, apiRoute);
        });

        const result = handlers.map(item => item.handler.handle(httpErrorCode, httpMethod, apiRoute));
        this.showMessages(result);
    }

    private showMessages(messages: Array<string>) {

    }

    private getIsApiRouteMatch(template: string, route: string) {
        if (!template) {
            return true;
        }

        if (!route) {
            return false;
        }

        const normalizedRoute = (route.endsWith('/')
            ? route.substr(0, route.length - 1)
            : route).toLocaleLowerCase();

        if (template.indexOf('*') === -1) {
            return template === route;
        }

        const templateSegments = template.split('/');
        const routeSegments = normalizedRoute.split('/');

        return templateSegments.length === routeSegments.length
            && templateSegments.every((v, i) => v === '*' || v === routeSegments[i]);
    }
}