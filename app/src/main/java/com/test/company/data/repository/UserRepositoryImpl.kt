package com.test.company.data.repository

import com.test.company.domain.model.User
import com.test.company.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun get(): User {
        return User(
            id = 0,
            firstName = "Username",
            lastName = "",
            photoUrl = ""
        )
    }
}