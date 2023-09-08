package com.test.company.domain.repository

import com.test.company.domain.model.User

interface UserRepository {

    fun get(): User
}
