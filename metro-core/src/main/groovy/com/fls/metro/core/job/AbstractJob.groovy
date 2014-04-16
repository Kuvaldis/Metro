package com.fls.metro.core.job

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 12:33
 */
abstract class AbstractJob implements Job {
    @Override
    JobPriority getPriority() {
        JobPriority.DEFAULT
    }
}
