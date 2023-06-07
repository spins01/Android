package {ROOT_PACKAGE_NAME}.{NAME}.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.core.view.WindowCompat
import com.app.module.base.AppRouterConfig
import com.app.module.base.support.translateStatusBar
import com.app.module.base.theme.AppTheme3
import com.app.module.base.view.AppBaseActivity
import com.app.module.base.view.compose.StateBar
import com.google.accompanist.pager.ExperimentalPagerApi

import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.support.annotation.ViewLayer
import com.xiaojinzi.support.ktx.initOnceUseViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@RouterAnno(
    hostAndPath = AppRouterConfig.xxx,
)
@ViewLayer
class {JAVA_NAME}Act : AppBaseActivity<{JAVA_NAME}ViewModel>() {

    override fun getViewModelClass(): Class<{JAVA_NAME}ViewModel> {
        return {JAVA_NAME}ViewModel::class.java
    }

    @OptIn(
        InternalCoroutinesApi::class,
        ExperimentalMaterial3Api::class,
        ExperimentalAnimationApi::class,
        ExperimentalPagerApi::class,
        ExperimentalFoundationApi::class,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.translateStatusBar()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        initOnceUseViewModel {
        }

        setContent {
            AppTheme3 {
                StateBar {
                    {JAVA_NAME}ViewWrap() 
                }
            }
        }

    }

}