package com.test.company.domain.usecase

import com.test.company.domain.common.AppCoroutineDispatcher
import com.test.company.domain.model.User
import com.test.company.domain.repository.UserRepository
import kotlinx.coroutines.withContext

class GetUserUseCase(
    private val repository: UserRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(): User {
        return withContext(dispatcher.IO) {
            repository.get()
        }
    }
}