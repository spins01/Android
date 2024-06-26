package com.spins.intech

import android.os.Build
import com.app.module.base.spi.AppInfoSpi
import com.xiaojinzi.component.anno.ServiceAnno
import com.xiaojinzi.module.common.base.spi.spPersistence
import com.xiaojinzi.support.ktx.AppScope
import com.xiaojinzi.support.ktx.MutableSharedStateFlow
import com.xiaojinzi.support.ktx.app
import kotlinx.coroutines.flow.map

//某一个模块
@ServiceAnno(AppInfoSpi::class)
class AppInfoSpiImpl : AppInfoSpi {

    override val appVersionName: String = try {
        app
            .packageManager
            .getPackageInfo(app.packageName, 0).versionName
    } catch (e: Exception) {
        "UnKnow"
    }

    override val appVersionCode: Long = try {
        app
            .packageManager
            .getPackageInfo(app.packageName, 0).run {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    this.longVersionCode
                } else {
                    this.versionCode.toLong()
                }
            }
    } catch (e: Exception) {
        0
    }

    override val appIconRsd: Int
        get() = R.mipmap.ic_launcher_round

    override val themeIndexStateOb = MutableSharedStateFlow<Int>()
        .spPersistence(
            scope = AppScope,
            key = "themeIndex",
            def = 0,
        )

    override val isDarkThemeStateOb = themeIndexStateOb
        .map {
            it == AppInfoSpi.THEME_DARK
        }

    override val themeColorIndexStateOb = MutableSharedStateFlow<Int>()
        .spPersistence(
            scope = AppScope,
            key = "themeColorIndex",
            def = 3,
        )

    override fun switchTheme(themeIndex: Int) {
        themeIndexStateOb.value = themeIndex
    }

    override fun switchThemeColor(themeIndex: Int) {
        themeColorIndexStateOb.value = themeIndex
    }

}