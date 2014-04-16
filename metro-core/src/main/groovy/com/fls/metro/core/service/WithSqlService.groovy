package com.fls.metro.core.service

import com.fls.metro.core.sql.SqlHolder
import org.springframework.beans.factory.annotation.Autowired

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 13:09
 */
abstract class WithSqlService {

    @Autowired
    private SqlHolder sqlHolder

    protected getSql() {
        sqlHolder.sql
    }
}
