package com.fls.metro.core.service

import com.fls.metro.core.data.dao.UserDao
import com.fls.metro.core.data.domain.Role
import com.fls.metro.core.data.domain.User
import com.fls.metro.core.exception.UserAlreadyExistsException
import com.fls.metro.core.security.UserDetailsImpl
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 13:10
 */
@Slf4j
@Service
class UserService extends WithSqlService implements UserDetailsService {
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired UserDao userDao

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = userDao.findByUsername(username)
        if (!user) {
            logger.info('User {} not found', username)
            throw new UsernameNotFoundException('user.not.found')
        }
        userDetails(user)
    }

    static UserDetails userDetails(User user) {
        new UserDetailsImpl(
                username: user.username,
                password: user.password,
                removed: user.removed,
                authorities: user.roles.collect {
                    new SimpleGrantedAuthority(it.name())
                } as Set)
    }

    User createUser(String username, String password, List<Role> roles) throws UserAlreadyExistsException {
        log.info('Start create user with name {}', username)
        User result = null
        sql.withTransaction {
            if (userDao.findByUsername(username)) {
                throw new UserAlreadyExistsException();
            }
            result = userDao.create(new User(username: username, password: password, roles: roles))
            log.info('User with name {} was successfully created', username)
        }
        return result
    }

    List<User> userList() {
        [new User(username: 'aaa')]
    }
}
