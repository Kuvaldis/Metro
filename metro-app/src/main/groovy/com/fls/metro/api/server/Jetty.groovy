package com.fls.metro.api.server

import com.sun.jersey.spi.spring.container.servlet.SpringServlet
import groovy.util.logging.Slf4j
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext

import javax.annotation.PostConstruct

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 16:47
 */
@Slf4j
class Jetty {
    Integer port
    String host
    List<ServletConfiguration> servlets
    private Server server

    @Autowired
    ApplicationContext applicationContext

    @PostConstruct
    def run() throws Exception {
        server = new Server(InetSocketAddress.createUnresolved(host, port))
        server.handler = createHandler()
        server.start()
        log.info("Server started on ${host}:${port}")
    }

    def createHandler() {
        ServletContextHandler handler = new ServletContextHandler()
        servlets.each {
            handler.addServlet(new ServletHolder(new SpringServlet() {
                @Override
                protected ConfigurableApplicationContext getDefaultContext() {
                    return (ConfigurableApplicationContext) applicationContext;
                }
            }), it.contextPath)
            handler.setInitParameter(SpringServlet.CONTEXT_CONFIG_LOCATION, it.configLocation)
        }
        return handler
    }
}
