package com.spins.intech.main.view

import com.spins.intech.main.domain.MainUseCase
import com.spins.intech.main.domain.MainUseCaseImpl
import com.xiaojinzi.reactive.view.BaseViewModel
import com.xiaojinzi.support.annotation.ViewLayer

@ViewLayer
class MainViewModel(
    private val useCase: MainUseCase = MainUseCaseImpl(),
): BaseViewModel(),
    MainUseCase by useCase{
}