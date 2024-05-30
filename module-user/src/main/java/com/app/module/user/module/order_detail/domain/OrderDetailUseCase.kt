package com.app.module.user.module.order_detail.domain

import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer

sealed class OrderDetailIntent {

    data object Submit : OrderDetailIntent()

}

@ViewModelLayer
interface OrderDetailUseCase : BusinessUseCase {
    // TODO
}

@ViewModelLayer
class OrderDetailUseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), OrderDetailUseCase {

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun submit(intent: OrderDetailIntent.Submit) {
        // TODO
    }
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}