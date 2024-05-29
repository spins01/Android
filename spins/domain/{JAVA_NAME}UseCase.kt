package {ROOT_PACKAGE_NAME}.{NAME}.domain

import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer

sealed class {JAVA_NAME}Intent {

    data object Submit : {JAVA_NAME}Intent()

}

@ViewModelLayer
interface {JAVA_NAME}UseCase : BusinessUseCase {
    // TODO
}

@ViewModelLayer
class {JAVA_NAME}UseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), {JAVA_NAME}UseCase {

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun submit(intent: {JAVA_NAME}Intent.Submit) {
        // TODO
    }
    
    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}