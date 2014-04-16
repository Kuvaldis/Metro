package com.fls.metro.core.config

import groovy.transform.TupleConstructor
import org.springframework.beans.factory.config.PropertiesFactoryBean

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 11:39
 */
@TupleConstructor
class MultiConfigPropertiesFactoryBean extends PropertiesFactoryBean {
    PropertiesHolder propertiesHolder;

    @Override
    protected void loadProperties(Properties props) throws IOException {
        props.putAll(propertiesHolder.toProperties())
    }
}
