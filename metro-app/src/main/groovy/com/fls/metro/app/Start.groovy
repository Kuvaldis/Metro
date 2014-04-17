package com.fls.metro.app

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.apache.commons.daemon.Daemon
import org.apache.commons.daemon.DaemonContext
import org.apache.commons.daemon.DaemonInitException
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 16:05
 */
@Slf4j
@CompileStatic
class Start implements Daemon {

    private static ClassPathXmlApplicationContext context
    private String[] arguments = new String[0]

    public static void main(String[] args) {
        log.info('Start application')
        try {
            def ctx = new ClassPathXmlApplicationContext(
                    'classpath*:coreContext.xml',
                    'classpath:applicationContext.xml')
            ctx.registerShutdownHook()
            ctx.refresh()
            log.info('Context created')
        } catch (Exception e) {
            log.error('Application error : {}', e)
            System.exit(1)
        }
    }

    @Override
    void init(DaemonContext context) throws DaemonInitException, Exception {
        arguments = context.getArguments()
    }

    @Override
    void start() throws Exception {
        main(arguments)
    }

    @Override
    void stop() throws Exception {
        context.destroy()
    }

    @Override
    void destroy() {
        context.destroy()
    }
}
