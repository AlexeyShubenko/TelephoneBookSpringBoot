package com.test.javaproject.config;

import com.test.javaproject.mvc.service.UserService;
import com.test.javaproject.mvc.service.impl.ContactServiceImpl;
import com.test.javaproject.mvc.service.impl.UserServiceImpl;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by Alexey on 20.05.2017.
 */
@Configuration
@EnableWebMvc  // включить аннотации Spring MVC, т.е. сказать контейнеру Spring-а реагировать на них
@ComponentScan(value = "com.test.javaproject.mvc.*")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        ///искать файл перевода с названием messages...
        messageSource.setBasenames("/WEB-INF/language/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800);
        return resolver;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean(name = "userServiceMock")
    public UserServiceImpl userServiceMock() {
        return Mockito.mock(UserServiceImpl.class);
    }

//    @Bean(name = "contactServiceMock")
//    public ContactServiceImpl contactServiceMock() {
//        return Mockito.mock(ContactServiceImpl.class);
//    }

}
