package com.fls.metro.core.exception

import groovy.transform.CompileStatic

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 14:28
 */
@CompileStatic
class UserAlreadyExistsException extends ServerException {
    UserAlreadyExistsException() {
        super('user.already.exists')
    }
}
