package com.fls.metro.core.data.dao

import com.fls.metro.core.data.domain.User
import org.springframework.stereotype.Repository

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 13:11
 */
@Repository
class UserDao extends AbstractDao<User> {
    User findByUsername(String username) {
        executeSelect username: username
    }
}
