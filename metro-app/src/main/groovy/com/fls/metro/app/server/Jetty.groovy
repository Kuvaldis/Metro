package com.fls.metro.app.server

import com.fls.metro.api.servlet.JerseyServlet
import com.sun.jersey.spi.spring.container.servlet.SpringServlet
import groovy.util.logging.Slf4j
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

import javax.annotation.PostConstruct
import javax.annotation.PreDestroy

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 16:47
 */
@Slf4j
class Jetty {
    Integer port
    String host
    List<RestServletConfiguration> restServlets
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

    @PreDestroy
    def stop() throws Exception {
        server.stop()
    }

    def createHandler() {
        ServletContextHandler handler = new ServletContextHandler()
        restServlets.each {
            def holder = new ServletHolder(new JerseyServlet(applicationContext))
            holder.setInitParameter(SpringServlet.CONTEXT_CONFIG_LOCATION, it.configLocation)
            holder.setInitParameter('com.sun.jersey.api.json.POJOMappingFeature', true as String)
            handler.addServlet(holder, it.contextPath)
        }
        return handler
    }
}
