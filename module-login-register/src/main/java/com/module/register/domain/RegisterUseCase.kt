package com.module.register.domain

import android.content.Context
import androidx.annotation.UiContext
import androidx.compose.ui.text.input.TextFieldValue
import com.app.module.base.bean.RegisterLoginInputStatus
import com.xiaojinzi.reactive.anno.IntentProcess
import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.reactive.template.domain.CommonUseCase
import com.xiaojinzi.reactive.template.domain.CommonUseCaseImpl
import com.xiaojinzi.support.annotation.ViewModelLayer
import kotlinx.coroutines.flow.MutableStateFlow

sealed class RegisterIntent {

   //数据就是事件
    //切换手机注册和邮箱注册的按钮
    data class SwitchTab( @UiContext val context: Context,val selectedIndex:Int):RegisterIntent()
    //手机号码输入改变的事件
//    data class ChangeMobileNumber(@UiContext val context: Context,val textFieldValue: TextFieldValue):RegisterIntent()
    ///手机号输入框的状态
//    data class MobileNumberStatus(@UiContext val context: Context,val status:RegisterLoginInputStatus)
     //手机号输入框获取焦点
    data class MobileNumberIsFocus(@UiContext val context: Context,val isFocus:Boolean):RegisterIntent()
}

@ViewModelLayer
interface RegisterUseCase : BusinessUseCase {
    //电话号码
    val registerPhoneNumber: MutableStateFlow<TextFieldValue>
    //选择的tab
    val selectedIndex:MutableStateFlow<Int>
    //输入的手机号变更(这里不走Intent)
    val phoneNumberChangeOb:MutableStateFlow<TextFieldValue>
    //手机号输入框的状态
    val mobileNumberStatusOB:MutableStateFlow<RegisterLoginInputStatus>
    //验证码输入的状态
    val sendVerifyCodeStatusOB:MutableStateFlow<RegisterLoginInputStatus>
    //验证码
    val mobileNumberSendCode: MutableStateFlow<TextFieldValue>
    //验证码的改变
    val mobileNumberSendCodeChange:MutableStateFlow<TextFieldValue>
}

@ViewModelLayer
class RegisterUseCaseImpl(
    private val commonUseCase: CommonUseCase = CommonUseCaseImpl(),
) : BusinessUseCaseImpl(
    commonUseCase = commonUseCase,
), RegisterUseCase {
    //手机号
    override val registerPhoneNumber: MutableStateFlow<TextFieldValue> = MutableStateFlow(value = TextFieldValue(text = ""))
    override val selectedIndex: MutableStateFlow<Int> = MutableStateFlow(value = 0)
    override val phoneNumberChangeOb: MutableStateFlow<TextFieldValue> = MutableStateFlow(value = TextFieldValue())
    override val mobileNumberStatusOB: MutableStateFlow<RegisterLoginInputStatus> = MutableStateFlow(value = RegisterLoginInputStatus.NORMAL)
    //手机号验证码
    override val sendVerifyCodeStatusOB: MutableStateFlow<RegisterLoginInputStatus> = MutableStateFlow(value = RegisterLoginInputStatus.NORMAL)
    override val mobileNumberSendCode: MutableStateFlow<TextFieldValue> = MutableStateFlow(value = TextFieldValue())
    override val mobileNumberSendCodeChange: MutableStateFlow<TextFieldValue> = MutableStateFlow(value = TextFieldValue())

    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun switchTab(intent: RegisterIntent.SwitchTab) {
           selectedIndex.value = intent.selectedIndex
    }
    @IntentProcess
    @BusinessUseCase.AutoLoading
    private suspend fun isMobilePhoneNumberFocused(intent: RegisterIntent.MobileNumberIsFocus) {
           if(intent.isFocus){
               mobileNumberStatusOB.value = RegisterLoginInputStatus.FOCUS
           }else{
               mobileNumberStatusOB.value = RegisterLoginInputStatus.NORMAL
           }
    }


//    @IntentProcess
//    @BusinessUseCase.AutoLoading
//    private suspend fun changeMobilePhoneNumber(intent: RegisterIntent.ChangeMobileNumber){
//        Log.e("赵云ViewModule","${intent.textFieldValue}")
//        registerPhoneNumber.value = intent.textFieldValue
//    }
//    @IntentProcess
//    @BusinessUseCase.AutoLoading
//    private suspend fun changeMobileNumberStatus(intent: RegisterIntent.MobileNumberStatus){
//
//    }



    override fun destroy() {
        super.destroy()
        commonUseCase.destroy()
    }

}