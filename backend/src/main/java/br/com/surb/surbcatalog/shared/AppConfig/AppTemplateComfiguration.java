package br.com.surb.surbcatalog.shared.AppConfig;

import br.com.surb.surbcatalog.shared.AppEnums.TemplateType;
import br.com.surb.surbcatalog.shared.AppProperties.AppEmailConfigProperties;
import br.com.surb.surbcatalog.shared.AppProperties.AppEmailTemplate;
import br.com.surb.surbcatalog.shared.AppProperties.AppTemplateConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableConfigurationProperties(AppTemplateConfigurationProperties.class)
public class AppTemplateComfiguration {
    private final Map<String, AppEmailTemplate> templates;

    public AppTemplateComfiguration(Map<String, AppEmailTemplate> templates) {
        this.templates = templates;
    }

    public AppEmailTemplate getEmailTemplate(TemplateType templateType) {
        return templates.get(templateType.getTemplateName());
    }
}
