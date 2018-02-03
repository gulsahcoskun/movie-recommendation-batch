package com.gulsah.moviedb.movierecommendationbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
//@Configuration
public class FreeMarkerConfig{

    @Bean
    public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration(){
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("/templates/");
        return bean;
    }
}
