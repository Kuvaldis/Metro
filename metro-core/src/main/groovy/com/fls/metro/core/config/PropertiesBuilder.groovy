package com.fls.metro.core.config

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 11:17
 */
@Slf4j
@Component('propertiesBuilder')
class PropertiesBuilder {
    PropertiesHolder build(List<String> configFilesList) {
        def env = System.getProperty("env")
        log.info('Run with profile: {}', env)
        ConfigObject resultConfig
        configFilesList.each {
            def config = new ConfigSlurper(env).parse(new File(it).toURI().toURL())
            if (!resultConfig) {
                resultConfig = config
            } else {
                resultConfig.merge(config)
            }
        }
        new PropertiesHolder(configObject: resultConfig)
    }
}
