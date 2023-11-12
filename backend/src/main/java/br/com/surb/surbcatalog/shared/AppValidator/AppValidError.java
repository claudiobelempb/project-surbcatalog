package br.com.surb.surbcatalog.shared.AppValidator;

import java.util.Objects;


public final class AppValidError {
  private final String field;
  private final String errorCode;

  public String getField() {
    return field;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public AppValidError(String field, String errorCode) {
    this.field = field;
    this.errorCode = errorCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppValidError that = (AppValidError) o;
    return field.equals(that.field) && errorCode.equals(that.errorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, errorCode);
  }

  @Override
  public String toString() {
    return "AppValidationErrorApp{" +
      "field='" + field + '\'' +
      ", errorCode='" + errorCode + '\'' +
      '}';
  }
}
