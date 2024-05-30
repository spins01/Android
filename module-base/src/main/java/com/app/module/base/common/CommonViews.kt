package com.app.module.base.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            fontWeight = FontWeight.Bold
        )
    )
}

/**
 * 注册登录界面的Tab
 */
@Composable
fun TabBar(selectedIndex:Int,onTabSelected: (Int) -> Unit) {

    //声明不可变的集合
    val tabs = listOf(
        LocalContext.current.getString(com.res.R.string.res_mobile),
        LocalContext.current.getString(com.res.R.string.res_email)
    )
    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = {_-> TabRowDefaults.Indicator(color = Color.Transparent)},
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
                content = {TabBarView(selectedIndex == index,content,onTabSelected,index)}

            )
        }
    }

}
@Composable
private fun TabBarView(isSelected: Boolean, content: String,onTabSelected: (Int) -> Unit,index:Int) {
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