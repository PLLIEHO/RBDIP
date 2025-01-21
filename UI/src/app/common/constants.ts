import { environment } from './../../environments/environment';

export class ApiPath {

  public static PlanningVoyageData = environment.apiUrl + 'info';
  public static Purpose = environment.apiUrl + 'purpose';
  public static Company = environment.apiUrl + 'company';
  public static Category = environment.apiUrl + 'category';
  public static Validate = environment.apiUrl + 'validate';
  public static Decline = environment.apiUrl + 'decline';

  public static Country = environment.apiUrl + 'countries';
  public static Job = environment.apiUrl + 'job';
  public static Luggage = environment.apiUrl + 'customs_param';
  public static Criminal = environment.apiUrl + 'criminal';
  public static Instruction = environment.apiUrl + 'instruction';

}

export class ErrorTexts {
  public static UsualError = 'Возникла проблема при получении данных. Попробуйте позже.'
}
