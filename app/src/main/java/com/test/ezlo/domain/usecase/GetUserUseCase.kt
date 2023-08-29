package com.test.ezlo.domain.usecase

import com.test.ezlo.domain.common.AppCoroutineDispatcher
import com.test.ezlo.domain.model.User
import com.test.ezlo.domain.repository.UserRepository
import kotlinx.coroutines.withContext

class GetUserUseCase(
    private val repository: UserRepository,
    private val dispatcher: AppCoroutineDispatcher,
) {
    suspend fun execute(): User {
        return withContext(dispatcher.IO) { repository.get() }
    }
}