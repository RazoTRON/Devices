package com.test.ezlo.data.repository

import com.test.ezlo.domain.model.User
import com.test.ezlo.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override fun get(): User {
        return User(
            id = 0,
            firstName = "Vladyslav",
            lastName = "Mihalatiuk",
            photoUrl = ""
        )
    }
}