package com.fls.metro.core.job

import com.googlecode.flyway.core.Flyway
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.sql.DataSource

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 12:34
 */
@Component
@CompileStatic
class DbMigrationJob extends AbstractJob {

    private Flyway flyway

    @Override
    JobPriority getPriority() {
        JobPriority.BIG
    }

    @Override
    void runJob() throws Exception {
        flyway.migrate()
    }

    @Autowired
    void setDataSource(DataSource dataSource) {
        flyway = new Flyway(dataSource: dataSource)
    }
}
