package br.com.surb.surbcatalog.shared.AppEnums;

public enum TemplateType {
    CREATED("created"),
    UPDATED("updated"),
    DELETED("deleted");

    final String templateName;

    TemplateType(String templateName){
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }
}
