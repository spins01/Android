package {ROOT_PACKAGE_NAME}.{NAME}.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.InternalCoroutinesApi

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.xiaojinzi.module.base.usecase.CommonContentView
import com.hh.emo.base.view.compose.EmoAppbarNormal
import com.xiaojinzi.support.ktx.nothing
import com.xiaojinzi.support.ktx.toStringItemDTO

@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
private fun {JAVA_NAME}View(paddingValues: PaddingValues = PaddingValues(all = 0.dp)) {
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

@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Composable
fun {JAVA_NAME}ViewWrap() {
    Scaffold(
        topBar = {
            EmoAppbarNormal(
                title = "hello".toStringItemDTO(),
            )
        }
    ) { paddingValues ->
        {JAVA_NAME}View(paddingValues = paddingValues)
    }
}

@InternalCoroutinesApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalFoundationApi
@Preview
@Composable
private fun {JAVA_NAME}ViewPreview() {
    {JAVA_NAME}View()
}