package com.app.module.base.common

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.text.input.TextFieldValue
import com.app.module.base.bean.RegisterLoginInputStatus

//注册界面
//val localPhoneNumber =
//    compositionLocalOf<TextFieldValue> { error("no value provided to localPhoneNumber") }
val localPhoneNumber =
    compositionLocalOf<androidx.compose.runtime.State<TextFieldValue>> { error("no value provided to localPhoneNumber") }
val localPhoneNumberState =
    compositionLocalOf<RegisterLoginInputStatus> { error("no value provided to localPhoneNumberState") }
val localFocusRequesterForPhoneNumber =
    compositionLocalOf<FocusRequester> { error("no value provided to localFocusRequesterForPhoneNumber") }
val localSendVerifyCodeStatus =
    compositionLocalOf<RegisterLoginInputStatus> { error("no value provided to localSendVerifyCodeStatus") }
val localSendCodeButtonIsEnable =
    compositionLocalOf<Boolean> { error("no value provided to localSendCodeButtonIsEnable") }
val localSendCodeInput =
    compositionLocalOf<TextFieldValue> { error("no value provided to localSendCodeInput") }
val localOnMobileFocusChanged =
    compositionLocalOf<(FocusState) -> Unit> { error("no value provided to localOnMobileFocusChanged") }
val localOnMobileChange =
    compositionLocalOf<(TextFieldValue) -> Unit> { error("no value provided to localOnMobileFocusChanged") }
val localCountryAreaCodeList =
    compositionLocalOf<List<String>> { error("no value provided to localCountryAreaCodeList") }

