package br.com.surb.surbcatalog.filters;

import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.Writer;
import java.util.UUID;

public class VerifyApiKeyFilter extends GenericFilterBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyApiKeyFilter.class);
    private static final String HEADER_API_KEY = "api-key";

    private final UserRepository userRepository;

    public VerifyApiKeyFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String userId = httpRequest.getHeader(HEADER_API_KEY);
        if (!StringUtils.isBlank(userId) && isValidApiKey(userId)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            sendUnauthorizedError(httpResponse, String.valueOf(userId));
        }
    }

    private boolean isValidApiKey(String userId) {
        return userRepository
                .findById(userId)
                .filter((u) -> u.getActive())
                .stream()
                .peek(u -> LOGGER.info("Valid API Key: '{}' ({}) ({})", u.getApiKey(), u.getFirstName(), u.getLastName()))
                .findFirst()
                .isPresent();
    }

    private void sendUnauthorizedError(HttpServletResponse httpServletResponse, String userId) throws IOException {
        String errorMessage = StringUtils.isBlank(String.valueOf(userId)) ? "API Key is missing" : "API Key is invalid";
        LOGGER.error(errorMessage);
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentLength(errorMessage.length());
        httpServletResponse.setContentType("plain/text");

        try (Writer out = httpServletResponse.getWriter()) {
            out.write(errorMessage);
        }
    }
}
