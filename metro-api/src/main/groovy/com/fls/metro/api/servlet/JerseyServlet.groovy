package com.fls.metro.api.servlet

import com.sun.jersey.spi.spring.container.servlet.SpringServlet
import groovy.transform.CompileStatic
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext

/**
 * User: NFadin
 * Date: 17.04.14
 * Time: 10:57
 */
@CompileStatic
class JerseyServlet extends SpringServlet {
    private ApplicationContext applicationContext;

    JerseyServlet(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected ConfigurableApplicationContext getDefaultContext() {
        return applicationContext as ConfigurableApplicationContext;
    }
}
