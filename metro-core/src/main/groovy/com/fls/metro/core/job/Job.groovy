package com.fls.metro.core.job

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 12:32
 */
public interface Job {
    JobPriority getPriority()
    void runJob() throws Exception
}