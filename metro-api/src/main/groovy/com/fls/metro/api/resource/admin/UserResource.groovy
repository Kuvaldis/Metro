package com.fls.metro.api.resource.admin

import com.fls.metro.core.data.domain.User
import com.fls.metro.core.service.UserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * User: NFadin
 * Date: 17.04.14
 * Time: 10:34
 */
@Path('user')
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
@Component
class UserResource {

    @Autowired
    private UserService userService

    @GET
    public List<User> users() {
        return userService.userList()
    }
}
