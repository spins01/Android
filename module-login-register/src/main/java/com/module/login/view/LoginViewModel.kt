package com.module.login.view

import com.module.login.domain.LoginUseCase
import com.module.login.domain.LoginUseCaseImpl
import com.xiaojinzi.reactive.view.BaseViewModel
import com.xiaojinzi.support.annotation.ViewLayer

@ViewLayer
class LoginViewModel(
    private val useCase: LoginUseCase = LoginUseCaseImpl(),
): BaseViewModel(),
    LoginUseCase by useCase{
}