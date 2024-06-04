package com.app.module.base.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.module.base.bean.RegisterLoginInputStatus
import com.app.module.base.bean.SendCodeButtonStatus
import com.xiaojinzi.support.ktx.nothing


/**
 * 注册登录背景界面
 */
@Composable
fun RegisterLoginBoxWithBg() {
    Image(
        painter = painterResource(id = com.res.R.drawable.login_register_bg),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}

/**
 * 注册登录最上面的图标
 */
@Composable
fun RegisterLoginIcon() {
    Image(
        painter = painterResource(id = com.res.R.drawable.register_login_logo),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(width = 106.dp, height = 42.dp)
            .nothing()
    )
}

/**
 * 注册登录的文字提示
 */
@Composable
fun RegisterLoginText(textShow: String) {
    Text(
        text = textShow,
        Modifier
            .wrapContentSize()
            .nothing(),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = com.res.R.color.res_color_0D2478)
        )
    )
}

/**
 * 注册登录界面的Tab
 */
@Composable
fun TabBar(tabs: List<String>, selectedIndex: Int, onTabSelected: (Int) -> Unit) {


    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = { _ -> TabRowDefaults.Indicator(color = Color.Transparent) },
        backgroundColor = Color.White,
        modifier = Modifier
            .size(width = 311.dp, height = 43.dp)
            .clip(
                RoundedCornerShape(999.dp)
            )
            .nothing()
    ) {
        tabs.forEachIndexed { index, content ->
            Tab(
                selected = selectedIndex == index,
                onClick = {},
                modifier = Modifier.padding(2.dp),
                content = { TabBarView(selectedIndex == index, content, onTabSelected, index) }

            )
        }
    }

}

@Composable
private fun TabBarView(
    isSelected: Boolean,
    content: String,
    onTabSelected: (Int) -> Unit,
    index: Int
) {
    val mModifier: Modifier = if (isSelected) {
        Modifier
            .size(width = 153.5.dp, height = 39.dp)
            .clip(RoundedCornerShape(999.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = com.res.R.color.res_color_2EAFFF), colorResource(
                            id =
                            com.res.R.color.res_color_167AFF
                        )
                    )
                )
            )
            .clickableNoRipple { onTabSelected(index) }
            .nothing()
    } else {
        Modifier
            .size(width = 153.5.dp, height = 39.dp)
            .background(Color.White)
            .clickableNoRipple { onTabSelected(index) }
            .nothing()
    }
    val mTextColor = if (isSelected) {
        Color.White
    } else {
        colorResource(id = com.res.R.color.res_color_667382)
    }
    Box(modifier = mModifier, contentAlignment = Alignment.Center) {
        Text(text = content, style = TextStyle(color = mTextColor, fontSize = 15.sp))
    }
}

/**
 * 电话号码注册
 */
@Composable
fun MobileRegisterLogin(
) {
    val onFocusChanged = localOnMobileFocusChanged.current
    val onValueChange = localOnMobileChange.current
    Row(
        modifier = Modifier.registerLoginItemModifier(localPhoneNumberState.current),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        AsyncImage(
            model = com.res.R.drawable.phone,
            contentDescription = null,
            modifier = Modifier.size(width = 15.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = localCountryAreaCodeList.current[0],
            fontSize = 14.sp,
            color = colorResource(id = com.res.R.color.res_color_090E15)
        )
        Spacer(modifier = Modifier.width(10.dp))
        BasicTextField(
            value = localPhoneNumber.current.value,
            onValueChange = { newValue -> onValueChange(newValue) },
            modifier = Modifier
                .weight(1f)
//                .focusRequester(localFocusRequesterForPhoneNumber.current)
                .fillMaxHeight()
                .padding(0.dp)
                .background(Color.Green)
                .onFocusChanged { focusState ->
                    onFocusChanged(focusState)
                },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//            isError = when (localPhoneNumberState.current) {
//                RegisterLoginInputStatus.ERROR -> true
//                else -> false
//            },
        )
//        TextField(
//            value = localPhoneNumber.current.value,
//            onValueChange = {newValue ->onValueChange(newValue)},
//            modifier = Modifier
//                .weight(1f)
////                .focusRequester(localFocusRequesterForPhoneNumber.current)
//                .fillMaxHeight()
//                .padding(0.dp)
//                .background(Color.Green)
//                .onFocusChanged { focusState ->
//                    onFocusChanged(focusState)
//                },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
//            isError = when (localPhoneNumberState.current) {
//                RegisterLoginInputStatus.ERROR -> true
//                else -> false
//            },
//            textStyle = TextStyle(color = colorResource(id = com.res.R.color.res_color_090E15), fontSize = 14.sp),
//            placeholder = { Text(text = LocalContext.current.getString(com.res.R.string.res_enter_phone_number), fontSize = 14.sp, color = colorResource(id = com.res.R.color.res_color_CED9E3))},
//            colors = TextFieldDefaults.colors(
//                focusedContainerColor = Color.Transparent,
//                unfocusedContainerColor = Color.Transparent,
//                disabledContainerColor = Color.Transparent,
//                errorContainerColor = Color.Transparent,
//            )
//        )
    }
}

/**
 * 发送手机验证码
 */
@Composable
fun SendVerifyCode(
    sendVerifyCodeState: RegisterLoginInputStatus,
    sendCode: TextFieldValue,
    onFocusChanged: (FocusState) -> Unit,
    onInputContentChange: (TextFieldValue) -> Unit,

    onSendCodeClick: () -> Unit,
    isSendButtonEnable: Boolean,
    sendCodeButtonStatus: SendCodeButtonStatus,
    second: Int
) {
    Row(
        modifier = Modifier.registerLoginItemModifier(sendVerifyCodeState),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        AsyncImage(
            model = com.res.R.drawable.verify,
            contentDescription = null,
            modifier = Modifier.size(width = 15.dp, height = 20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        TextField(
            value = sendCode,
            onValueChange = onInputContentChange,
            modifier = Modifier
                .weight(1f)
                .onFocusChanged { focusState ->
                    onFocusChanged(focusState)
                },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            isError = when (sendVerifyCodeState) {
                RegisterLoginInputStatus.ERROR -> true
                else -> false
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
            )
        )
        val brushEnabled = Brush.linearGradient(
            colors = listOf(
                colorResource(id = com.res.R.color.res_color_2EAFFF),
                colorResource(id = com.res.R.color.res_color_167AFF)
            )
        )
        val brushDisable = Brush.linearGradient(
            colors = listOf(
                colorResource(id = com.res.R.color.res_color_2EAFFF).copy(alpha = 0.3f),
                colorResource(id = com.res.R.color.res_color_167AFF).copy(alpha = 0.3f)
            )
        )
        val sendCodeButtonBrush = if (isSendButtonEnable) {
            brushEnabled
        } else {
            brushDisable
        }
        val sendCodeButtonWidth = when (sendCodeButtonStatus) {
            SendCodeButtonStatus.SEND -> 55.dp
            SendCodeButtonStatus.RESEND -> 82.dp
            SendCodeButtonStatus.RESEND_WITH_SECONDS -> 118.dp
        }

        val sendCodeButtonText = when (sendCodeButtonStatus) {
            SendCodeButtonStatus.SEND -> LocalContext.current.getText(com.res.R.string.res_send)
            SendCodeButtonStatus.RESEND -> LocalContext.current.getText(com.res.R.string.res_resend)
            SendCodeButtonStatus.RESEND_WITH_SECONDS -> "${LocalContext.current.getText(com.res.R.string.res_resend)}(${second}s)"
        }


        TextButton(
            onClick = onSendCodeClick,
            Modifier
                .size(width = sendCodeButtonWidth, height = 36.dp)
                .clip(
                    RoundedCornerShape(6.dp)
                )
                .background(
                    brush = sendCodeButtonBrush
                )
        ) {
            Text(text = sendCodeButtonText.toString(), style = TextStyle(color = Color.White))
        }
    }
}
