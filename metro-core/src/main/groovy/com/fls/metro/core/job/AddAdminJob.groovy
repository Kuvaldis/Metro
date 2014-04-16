package com.fls.metro.core.job

import com.fls.metro.core.data.domain.Role
import com.fls.metro.core.service.UserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 13:07
 */
@Slf4j
@Component
class AddAdminJob extends AbstractJob {

    @Autowired
    UserService userService

    @Override
    void runJob() throws Exception {
//        userService.createUser('admin', 'admin', [Role.ADMIN])
    }
}
