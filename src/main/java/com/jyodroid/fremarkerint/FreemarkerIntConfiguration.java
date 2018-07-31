package com.jyodroid.fremarkerint;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class FreemarkerIntConfiguration implements WebMvcConfigurer {

    private static final String LANG_PARAMETER = "lang";
    private static final String UTF_ENCODING = "UTF-8";
    private static final String MAIN_SOURCE = "locale/main/greetings";
    private static final String LANG_SOURCE = "locale/lang/messages";

    //This bean is created inorder to determine which locale is currently being used
    //Can use session, cookies, Accept-language header or fixed value
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.US);
        return cookieLocaleResolver;
    }

    //Switch to a new locale based on the value of the lang parameter appended to a request
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName(LANG_PARAMETER);
        return localeChangeInterceptor;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasenames(MAIN_SOURCE, LANG_SOURCE);

        messageSource.setDefaultEncoding(UTF_ENCODING);
        return messageSource;
    }

    //    add the bean to interceptor registry
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
    }

}
