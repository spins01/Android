package com.spins.intech.main.domain

import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer

sealed class MainIntent {

    data object Submit : MainIntent()

}

@ViewModelLayer
interface MainUseCase : BusinessUseCase {
    // TODO
}

@ViewModelLayer
class MainUseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), MainUseCase {

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun submit(intent: MainIntent.Submit) {
        // TODO
    }
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}