package com.app.module.user

import com.app.module.base.spi.TestAPI
import com.xiaojinzi.component.impl.service.ServiceManager

class TestObject {
    fun abcd(){
        //requestGet(肯定存在)和Get(不一定存在)，模块是否存在
        ServiceManager.requiredGet(tClass = TestAPI::class).xxx();
    }
}