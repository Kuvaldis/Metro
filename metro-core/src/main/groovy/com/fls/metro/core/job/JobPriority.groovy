package com.fls.metro.core.job

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 12:33
 */
public enum JobPriority {

    SMALL(9),
    MEDIUM(4),
    DEFAULT(4),
    BIG(0)

    def final Integer priority

    JobPriority(Integer priority) {
        this.priority = priority
    }
}