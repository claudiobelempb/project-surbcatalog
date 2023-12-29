package br.com.surb.surbcatalog.shared.AppProperties;

import br.com.surb.surbcatalog.shared.AppEnums.TemplateType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "app.email")
public class AppTemplateConfigurationProperties {
    private final Map<String, AppEmailTemplate> templates;

    public AppTemplateConfigurationProperties(Map<String, AppEmailTemplate> templates) {
        this.templates = templates;
        //System.out.println("AppEmailTemplate: " + templates);
    }

    public AppEmailTemplate getEmailTemplate(TemplateType templateType) {
        return templates.get(templateType.getTemplateName());
    }
}
