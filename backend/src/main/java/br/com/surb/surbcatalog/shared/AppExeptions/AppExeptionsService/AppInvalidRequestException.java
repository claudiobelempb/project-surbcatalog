package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;


import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;

public class AppInvalidRequestException extends RuntimeException {

  private final AppValidationErrors validationErrors;

  public AppInvalidRequestException(AppValidationErrors appValidateErrors) {
    super(appValidateErrors.toString());
    this.validationErrors = appValidateErrors;
  }

  public AppValidationErrors getValidationErrors(){
    return this.validationErrors;
  }

  public AppInvalidRequestException(String msg, AppValidationErrors appValidateErrors){
    super(msg);
    this.validationErrors = appValidateErrors;
  }

}