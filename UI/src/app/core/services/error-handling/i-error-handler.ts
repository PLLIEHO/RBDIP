export interface IErrorHandler {
    handle(httpErrorCode: number, httpMethod: string, apiRoute: string): string;
}
