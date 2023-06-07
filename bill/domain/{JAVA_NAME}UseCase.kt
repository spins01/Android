package {ROOT_PACKAGE_NAME}.{NAME}.domain

import com.xiaojinzi.module.common.base.usecase.CommonBaseUseCase
import com.xiaojinzi.module.common.base.usecase.CommonBaseUseCaseImpl
import com.xiaojinzi.support.annotation.HotObservable
import com.xiaojinzi.support.annotation.ViewModelLayer
import com.xiaojinzi.support.architecture.mvvm1.CommonUseCase
import com.xiaojinzi.support.architecture.mvvm1.CommonUseCaseImpl

@ViewModelLayer
interface {JAVA_NAME}UseCase : CommonBaseUseCase, CommonUseCase {
    // TODO
}

@ViewModelLayer
class {JAVA_NAME}UseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : CommonBaseUseCaseImpl(),
    CommonUseCase by commonUseCase,
    {JAVA_NAME}UseCase {
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}