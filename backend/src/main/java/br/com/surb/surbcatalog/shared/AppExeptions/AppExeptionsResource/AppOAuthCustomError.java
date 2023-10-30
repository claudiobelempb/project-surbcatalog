package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppOAuthCustomError {
  private String error;

  @JsonProperty("error_description")
  private String errorDescription;

  public AppOAuthCustomError(){}

  public AppOAuthCustomError(String error, String errorDescription) {
    this.error = error;
    this.errorDescription = errorDescription;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }
}
