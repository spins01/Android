package com.app.module.test

import com.app.module.base.spi.TestAPI
import com.xiaojinzi.component.anno.ServiceAnno

@ServiceAnno(TestAPI::class)
class TestAPIImp : TestAPI {
    override fun xxx() {
//       LogSupport.e();
    }
}