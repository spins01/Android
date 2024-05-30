package com.module.login.domain

import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer

sealed class LoginIntent {

    data object Submit : LoginIntent()

}

@ViewModelLayer
interface LoginUseCase : BusinessUseCase {
    // TODO
}

@ViewModelLayer
class LoginUseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), LoginUseCase {

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun submit(intent: LoginIntent.Submit) {
        // TODO
    }
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}