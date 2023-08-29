package com.test.ezlo.domain.repository

import com.test.ezlo.domain.model.User

interface UserRepository {

    fun get(): User
}
