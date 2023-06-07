package {ROOT_PACKAGE_NAME}.{NAME}.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import com.google.accompanist.pager.ExperimentalPagerApi
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.module.base.RouterConfig
import com.xiaojinzi.module.base.ui.theme.BillTheme
import com.xiaojinzi.module.base.ui.view.BaseActivity
import com.xiaojinzi.support.annotation.ViewLayer
import com.xiaojinzi.support.compose.StateBar
import com.xiaojinzi.support.ktx.initOnceUseViewModel
import com.xiaojinzi.support.ktx.translateStatusBar
import kotlinx.coroutines.InternalCoroutinesApi

@RouterAnno(hostAndPath = RouterConfig.xxx)
@ViewLayer
class {JAVA_NAME}Act : BaseActivity<{JAVA_NAME}ViewModel>() {

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
            BillTheme {
                StateBar {
                    {JAVA_NAME}ViewWrap() 
                }
            }
        }

    }

}