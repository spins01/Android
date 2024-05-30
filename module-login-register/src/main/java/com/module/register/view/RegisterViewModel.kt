package com.module.register.view

import com.module.register.domain.RegisterUseCase
import com.module.register.domain.RegisterUseCaseImpl
import com.xiaojinzi.reactive.view.BaseViewModel
import com.xiaojinzi.support.annotation.ViewLayer

@ViewLayer
class RegisterViewModel(
    private val useCase: RegisterUseCase = RegisterUseCaseImpl(),
): BaseViewModel(),
    RegisterUseCase by useCase{
}