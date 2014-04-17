package com.fls.metro.app

import groovy.util.logging.Slf4j
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 16:05
 */
@Slf4j
class Start {
    public static void main(String[] args) {
        log.info('Start application')
        def ctx = new ClassPathXmlApplicationContext(
                'classpath*:coreContext.xml',
                'classpath:applicationContext.xml')
        ctx.registerShutdownHook()
        ctx.refresh()
        log.info('Context created')
    }
}
