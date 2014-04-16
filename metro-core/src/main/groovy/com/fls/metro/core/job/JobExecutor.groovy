package com.fls.metro.core.job

import com.google.common.base.CaseFormat
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 12:38
 */
@Slf4j
@Component
class JobExecutor {
    List<Job> jobs = []

    @PostConstruct
    init() {
        runJobs()
    }

    private void runJobs() {
        log.info('Execute lib jobs')
        jobs.each {
            def jobName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, it.class.simpleName).replace('_', ' ')
            log.info("Start $jobName")
            def start = System.currentTimeMillis()
            try {
                it.runJob()
                log.info("Done $jobName in ${System.currentTimeMillis() - start} ms")
            } catch (Exception e) {
                log.error("error on $jobName")
                throw new RuntimeException(e)
            }
        }
    }

    @Autowired
    void setJobs(List<Job> jobs) {
        this.jobs = jobs.asList().sort {
            it.priority.priority
        }
    }
}
