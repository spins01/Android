package com.module.register.view

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.module.base.common.RegisterLoginBoxWithBg
import com.app.module.base.common.RegisterLoginIcon
import com.app.module.base.common.RegisterLoginText
import com.app.module.base.common.TabBar
import com.xiaojinzi.reactive.template.view.BusinessContentView
import com.xiaojinzi.support.ktx.nothing
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
private fun RegisterView(
    needInit: Boolean? = null,
) {
    val context = LocalContext.current
    BusinessContentView<RegisterViewModel>(
        needInit = needInit,
    ) { vm ->
        var selectedIndex by remember {
            mutableIntStateOf(0)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(
                    color = Color.White.copy(alpha = 0f)
                )
                .nothing(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(23.dp))
            RegisterLoginIcon()
            Spacer(modifier = Modifier.height(13.dp))
            RegisterLoginText(context.getString(com.res.R.string.res_sign_in))
            Spacer(modifier = Modifier.height(26.dp))
            TabBar(selectedIndex) { selectedIndex = it }
        }
    }
}

@InternalCoroutinesApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun RegisterViewWrap() {
    Scaffold{
        Box(
            modifier = Modifier
                .fillMaxSize()
                .nothing(),
        ) {
            RegisterLoginBoxWithBg()
            RegisterView()
        }
    }
}

@InternalCoroutinesApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
private fun RegisterViewPreview() {
    RegisterView(
        needInit = false,
    )
}