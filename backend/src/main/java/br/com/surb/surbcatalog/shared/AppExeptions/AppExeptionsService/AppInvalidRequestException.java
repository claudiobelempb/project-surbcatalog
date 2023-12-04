package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;


import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;

public class AppInvalidRequestException extends RuntimeException {

  private final AppValidationErrors validationErrors;

  public AppInvalidRequestException(AppValidationErrors appValidateErrors) {
    super(appValidateErrors.toString());
    this.validationErrors = appValidateErrors;
  }

  public AppInvalidRequestException(String field, String erroCode) {
    this(new AppValidError(field, erroCode));
  }

  public AppInvalidRequestException(AppValidError appValidError) {
    this(new AppValidationErrors().addErrors(appValidError));
  }

  public AppValidationErrors getValidationErrors(){
    return this.validationErrors;
  }

  public AppInvalidRequestException(String msg, AppValidationErrors appValidateErrors){
    super(msg);
    this.validationErrors = appValidateErrors;
  }

}