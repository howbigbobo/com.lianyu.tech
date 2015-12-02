package com.lianyu.tech.backoffice.web.interceptor;

import com.lianyu.tech.backoffice.web.SiteContext;
import com.lianyu.tech.core.platform.web.ControllerHelper;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Inject
    SiteContext siteContext;

    private static final String REST_HEADER = "x-requested-with";
    private static final String REST_IDENTITY = "XMLHttpRequest";

    String adminLoginAddress = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            LoginRequired loginRequired = ControllerHelper.findMethodOrClassLevelAnnotation(handler, LoginRequired.class);
            if (loginRequired != null && !siteContext.isLogin()) {
                handleLoginValidateFailure(request, response);
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }

    private void handleLoginValidateFailure(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (isRestRequest(request)) {
            response.getWriter().write("The session is time out,please login again!");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.flushBuffer();
        } else {
            response.sendRedirect(request.getContextPath() + adminLoginAddress);
        }
    }

    private boolean isRestRequest(HttpServletRequest request) {
        String ajaxHeader = request.getHeader(REST_HEADER);
        return StringUtils.hasText(ajaxHeader) && REST_IDENTITY.equalsIgnoreCase(ajaxHeader);
    }

}
