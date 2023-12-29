package br.com.surb.surbcatalog.shared.AppConfig;

import br.com.surb.surbcatalog.filters.VerifyApiKeyFilter;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppFilterConfiguration {

    private final UserRepository userRepository;

    public AppFilterConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public FilterRegistrationBean<VerifyApiKeyFilter> verifyApiKeyFilter() {
        FilterRegistrationBean<VerifyApiKeyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new VerifyApiKeyFilter(userRepository));
        filterFilterRegistrationBean.addUrlPatterns("");
//        filterFilterRegistrationBean.addUrlPatterns("/rooms/*", "/allocations/*");
        return filterFilterRegistrationBean;
    }
}
