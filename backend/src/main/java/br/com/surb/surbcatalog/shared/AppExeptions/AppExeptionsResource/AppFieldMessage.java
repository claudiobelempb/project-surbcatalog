package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource;

public class AppFieldMessage {
    private String fieldName;
    private String message;

    public AppFieldMessage() {
    }

    public AppFieldMessage(String fieldName, String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;
    }

    public AppFieldMessage(String message) {
        super();
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
