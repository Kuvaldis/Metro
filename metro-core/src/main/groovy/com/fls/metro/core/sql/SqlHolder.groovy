package com.fls.metro.core.sql

import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.sql.DataSource

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 11:55
 */
@Component
class SqlHolder {
    @Autowired
    DataSource dataSource

    ThreadLocal<Sql> sqlThreadLocal = new ThreadLocal<>()

    def getSql() {
        def sql = sqlThreadLocal.get()
        if (!sql) {
            sql = new Sql(dataSource)
            sqlThreadLocal.set(sql)
        }
        return sql
    }
}
