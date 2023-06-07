package {ROOT_PACKAGE_NAME}.{NAME}.view

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.xiaojinzi.module.base.ui.view.compose.AppbarNormal
import com.xiaojinzi.module.common.base.usecase.CommonContentView
import com.xiaojinzi.support.ktx.nothing
import com.xiaojinzi.support.ktx.toStringItemDto

@OptIn(
    InternalCoroutinesApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class,
    ExperimentalPagerApi::class,
    ExperimentalFoundationApi::class,
)
@Composable
private fun {JAVA_NAME}View() {
    val context = LocalContext.current
    CommonContentView<{JAVA_NAME}ViewModel> { vm ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .nothing(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // empty
        }
    }
    
}

@OptIn(
    InternalCoroutinesApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class,
    ExperimentalPagerApi::class,
    ExperimentalFoundationApi::class,
)
@Composable
fun {JAVA_NAME}ViewWrap() {
    Scaffold(
        topBar = {
            AppbarNormal(
                title = "hello".toStringItemDto(),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .nothing(),
        ) {
            {JAVA_NAME}View()
        }
    }
}

@OptIn(
    InternalCoroutinesApi::class,
    ExperimentalMaterial3Api::class,
    ExperimentalAnimationApi::class,
    ExperimentalPagerApi::class,
    ExperimentalFoundationApi::class,
)
@Preview
@Composable
private fun {JAVA_NAME}ViewPreview() {
    {JAVA_NAME}View()
}