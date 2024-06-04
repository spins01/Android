package com.module.register.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.module.base.bean.RegisterLoginInputStatus
import com.app.module.base.common.MobileRegisterLogin
import com.app.module.base.common.RegisterLoginBoxWithBg
import com.app.module.base.common.RegisterLoginIcon
import com.app.module.base.common.RegisterLoginText
import com.app.module.base.common.TabBar
import com.module.register.domain.RegisterIntent
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
        val selectedIndex by vm.selectedIndex.collectAsState(initial = 0)
        //声明不可变的集合，手机注册和邮箱注册
        val tabs = listOf(
            context.getString(com.res.R.string.res_mobile),
            context.getString(com.res.R.string.res_email)
        )
        //声明不可变的集合，国家区号，目前只有菲律宾
        val countryAreaCodeList = listOf(
            context.getString(com.res.R.string.res_63)
        )
        val pageState = rememberPagerState {
            tabs.size
        }
        val phoneNumberStateOb by vm.registerPhoneNumber.collectAsState(initial = TextFieldValue())
        val phoneNumberState by vm.mobileNumberStatusOB.collectAsState(initial = RegisterLoginInputStatus.NORMAL)
//        val phoneNumberChangeOb by vm.phoneNumberChangeOb.collectAsState(initial = TextFieldValue())
        val focusRequesterForPhoneNumber = remember { FocusRequester() }


        val sendVerifyCodeStatus by vm.sendVerifyCodeStatusOB.collectAsState(initial = RegisterLoginInputStatus.NORMAL)
        val sendCodeButtonIsEnable by vm.sendCodeButtonIsEnabledOB.collectAsState(initial = false)
        val sendCodeInput by vm.sendCodeInputOb.collectAsState(initial = TextFieldValue())
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
            RegisterLoginText(context.getString(com.res.R.string.res_sign_up))
            Spacer(modifier = Modifier.height(26.dp))
            TabBar(tabs, selectedIndex) {
                vm.addIntent(
                    intent = RegisterIntent.SwitchTab(
                        context,
                        selectedIndex = it
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            HorizontalPager(
                modifier = Modifier.wrapContentSize(),
                state = pageState,
                pageSpacing = 0.dp,
                userScrollEnabled = false,
                reverseLayout = false,
                contentPadding = PaddingValues(0.dp),
                beyondBoundsPageCount = 0,
                pageSize = PageSize.Fill,
            ) { page ->
                when (page) {
                    0 -> {
                        MobileRegister(focusRequesterForPhoneNumber,
                            phoneNumberState,
                            countryAreaCodeList,
                            phoneNumberStateOb,
                            { focusState ->
                                vm.addIntent(
                                    intent = RegisterIntent.MobileNumberIsFocus(
                                        context,
                                        focusState.isFocused
                                    )
                                )
                            }
                        ) { textFieldValue ->
                            Log.e("赵云", "${textFieldValue}")
                            //绝大部分事件都可以走Intent,但是文字输入除外 因为文字输入如果走 intent 的话
                            //intent 的响应速度跟不上输入的速度
                            //会出现你连续输入3个字符 最终显示2个的问题，其他都是走 intent
                            //就文字变更这种是特别的
//                            vm.addIntent(RegisterIntent.ChangeMobileNumber(context,textFieldValue))
                            vm.phoneNumberChangeOb.value =
                                textFieldValue.copy(text = textFieldValue.text.trim())

                        }
                    }

                    1 -> {
                        EmailRegister()
                    }
                }
            }
        }
    }
}

@Composable
private fun MobileRegister(
    focusRequesterForPhoneNumber: FocusRequester,
    phoneNumberState: RegisterLoginInputStatus,
    countryAreaCodeList: List<String>,
    phoneNumberStateOb: TextFieldValue,
    onMobileFocusChanged: (FocusState) -> Unit,
    onMobileChange: (TextFieldValue) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        MobileRegisterLogin(
            focusRequesterForPhoneNumber,
            phoneNumberState,
            countryAreaCodeList,
            phoneNumberStateOb,
            onMobileFocusChanged,
            onMobileChange
        )
        Spacer(modifier = Modifier.height(15.dp))
//        SendVerifyCode(sendVerifyCodeStatus，)
    }
}

@Composable
private fun EmailRegister() {
    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@InternalCoroutinesApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun RegisterViewWrap() {
    Scaffold {
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
