package ru.itis.app;

import ru.itis.config.MvcConfig;
import ru.itis.config.WebSocketConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebSocketConfig.class, MvcConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebSocketConfig.class, MvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
