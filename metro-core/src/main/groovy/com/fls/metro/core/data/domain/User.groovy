package com.fls.metro.core.data.domain

import com.fls.metro.core.annotation.Id
import com.fls.metro.core.annotation.Seq
import com.fls.metro.core.annotation.Table
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * User: NFadin
 * Date: 16.04.14
 * Time: 13:04
 */
@ToString
@EqualsAndHashCode
@Table('users')
@Seq('user_seq')
class User {
    @Id Long id
    String username
    String password
    Boolean removed
    List<Role> roles
}
