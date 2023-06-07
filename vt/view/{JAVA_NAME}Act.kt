package {ROOT_PACKAGE_NAME}.{NAME}.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.support.annotation.ViewLayer
import com.xiaojinzi.support.ktx.initOnceUseViewModel
import com.xiaojinzi.vt.module.base.support.VtRouterConfig
import com.xiaojinzi.vt.module.base.support.translateStatusBar
import com.xiaojinzi.vt.module.base.theme.VtTheme
import com.xiaojinzi.vt.module.base.view.VtBaseActivity
import com.xiaojinzi.vt.module.base.view.compose.StateBar
import kotlinx.coroutines.InternalCoroutinesApi

@RouterAnno(
    hostAndPath = VtRouterConfig.XXX,
)
@ViewLayer
class {JAVA_NAME}Act : VtBaseActivity<{JAVA_NAME}ViewModel>() {

    override fun getViewModelClass(): Class<{JAVA_NAME}ViewModel> {
        return {JAVA_NAME}ViewModel::class.java
    }

    @OptIn(
        InternalCoroutinesApi::class,
        ExperimentalMaterialApi::class,
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
            VtTheme {
                StateBar {
                    {JAVA_NAME}ViewWrap()
                }
            }
        }

    }

}