package com.gulsah.moviedb.movierecommendationbatch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by GulsahCoskun on 3.02.2018.
 */
@Service
public class MailList {

    private static final Logger logger = LoggerFactory.getLogger(MailList.class);

    private Properties prop = null;

    public MailList(){
        InputStream is = null;
        try {
            this.prop = new Properties();
            is = this.getClass().getResourceAsStream("/mail-list.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            logger.error(e.toString());
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    public Collection<Object> getAllValues(){
        return prop.values();
    }


}
