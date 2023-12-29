package br.com.surb.surbcatalog.shared.AppConfig;

import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppOAuthCustomError;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppStandarError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationError;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppResourceAdviceExceptionHandler {
  private final AppStandarError error = new AppStandarError();

  @ExceptionHandler(AppEntityNotFoundException.class)
  public ResponseEntity<AppStandarError> entityNotFound(
    AppEntityNotFoundException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.NOT_FOUND;
    AppStandarError err = new AppStandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(AppExceptionConstants.NOT_FOUND);
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(AppDataIntegrityViolationException.class)
  public ResponseEntity<AppStandarError> database(AppDataIntegrityViolationException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.BAD_REQUEST;
    AppStandarError err = new AppStandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(AppExceptionConstants.BAD_REQUEST);
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(AppMessagingException.class)
  public ResponseEntity<AppStandarError> sendError(AppMessagingException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    AppStandarError err = new AppStandarError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(AppExceptionConstants.UNPROCESSABLE_ENTITY);
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<AppValidationError> validation(
    MethodArgumentNotValidException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    AppValidationError err = new AppValidationError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(AppExceptionConstants.UNPROCESSABLE_ENTITY);
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());

    for (FieldError field : e.getBindingResult().getFieldErrors()) {
      err.addError( field.getField(), field.getField(), field.getDefaultMessage());
    }
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(AppForbiddenException.class)
  public ResponseEntity<AppOAuthCustomError> forbidden(AppForbiddenException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.FORBIDDEN;
    AppOAuthCustomError customError = new AppOAuthCustomError(AppExceptionConstants.FORBIDDEN, e.getMessage());
    return ResponseEntity.status(status).body(customError);
  }

  @ExceptionHandler(AppUnauthorizedException.class)
  public ResponseEntity<AppOAuthCustomError> unauthorized(AppUnauthorizedException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNAUTHORIZED;
    AppOAuthCustomError customError = new AppOAuthCustomError(AppExceptionConstants.UNAUTHORIZED, e.getMessage());
    return ResponseEntity.status(status).body(customError);
  }

  @ExceptionHandler(AppInvalidRequestException.class)
  public ResponseEntity<AppValidationError> validation(
          AppInvalidRequestException e, HttpServletRequest request) {
    HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
    AppValidationError err = new AppValidationError();
    err.setTimestamp(Instant.now());
    err.setStatus(status.value());
    err.setError(AppExceptionConstants.UNPROCESSABLE_ENTITY);
    err.setMessage(e.getMessage());
    err.setPath(request.getRequestURI());

    for (AppValidError field : e.getValidationErrors()) {
      err.addError( field.getField(), field.getField(), field.getErrorCode());
    }
    return ResponseEntity.status(status).body(err);
  }

}
