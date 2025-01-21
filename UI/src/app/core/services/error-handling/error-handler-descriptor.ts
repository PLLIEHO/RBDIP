import { IErrorHandler } from "./i-error-handler";

export class ErrorHandlerDescriptor {
    httpErrorCode?: number;
    apiRoute?: string;
    httpMethod?: string;
    handler: IErrorHandler;
}