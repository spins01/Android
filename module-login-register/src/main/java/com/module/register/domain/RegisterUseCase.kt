package com.module.register.domain

import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer

sealed class RegisterIntent {

    data object Submit : RegisterIntent()

}

@ViewModelLayer
interface RegisterUseCase : BusinessUseCase {
    // TODO
}

@ViewModelLayer
class RegisterUseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), RegisterUseCase {

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun submit(intent: RegisterIntent.Submit) {
        // TODO
    }
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}