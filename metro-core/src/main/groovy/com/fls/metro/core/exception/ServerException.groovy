package com.fls.metro.core.exception

import groovy.transform.CompileStatic

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 14:27
 */
@CompileStatic
abstract class ServerException extends Exception {
    private String code

    ServerException(String code) {
        this.code = code
    }
}
