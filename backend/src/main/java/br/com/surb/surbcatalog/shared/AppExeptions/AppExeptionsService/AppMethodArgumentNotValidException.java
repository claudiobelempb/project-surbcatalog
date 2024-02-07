package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

import br.com.surb.surbcatalog.shared.AppValidator.AppValidErrors;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;

public class AppMethodArgumentNotValidException extends RuntimeException {
    private final AppValidErrors appValidErrors;

    public AppMethodArgumentNotValidException(AppValidErrors appValidErrors) {
        super(appValidErrors.toString());
        this.appValidErrors = appValidErrors;
    }

    public AppMethodArgumentNotValidException(String field, String messageError) {
        this(new AppValidFieldMessage(field, messageError));
    }

    public AppMethodArgumentNotValidException(AppValidFieldMessage appValidFieldMessage) {
        this(new AppValidErrors().addErrors(appValidFieldMessage));
    }

    public AppValidErrors getValidationErrors() {
        return this.appValidErrors;
    }

    public AppMethodArgumentNotValidException(String msg, AppValidErrors appValidErrors) {
        super(msg);
        this.appValidErrors = appValidErrors;
    }
}
