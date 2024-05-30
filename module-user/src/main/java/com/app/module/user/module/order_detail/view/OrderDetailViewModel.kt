package com.app.module.user.module.order_detail.view

import com.app.module.user.module.order_detail.domain.OrderDetailUseCase
import com.app.module.user.module.order_detail.domain.OrderDetailUseCaseImpl
import com.xiaojinzi.reactive.view.BaseViewModel
import com.xiaojinzi.support.annotation.ViewLayer

@ViewLayer
class OrderDetailViewModel(
    private val useCase: OrderDetailUseCase = OrderDetailUseCaseImpl(),
): BaseViewModel(),
    OrderDetailUseCase by useCase{
}