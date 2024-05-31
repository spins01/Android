package com.app.module.base.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.app.module.base.bean.RegisterLoginInputStatus
import com.xiaojinzi.support.ktx.nothing

/**
 * 没有涟漪效果的点击
 */
fun Modifier.clickableNoRipple(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
) = composed {
    Modifier.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick,
    )
}

fun Modifier.registerLoginItemModifier(
    phoneNumberState: RegisterLoginInputStatus
) = composed {
    when (phoneNumberState) {
        RegisterLoginInputStatus.ERROR -> {
            Modifier
                .border(
                    BorderStroke(2.dp, colorResource(id = com.res.R.color.res_color_f7391f)),
                    shape = RoundedCornerShape(6.dp)
                )
                .size(width = 311.dp, height = 42.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .nothing()
        }
        RegisterLoginInputStatus.FOCUS -> {
            Modifier
                .border(
                    BorderStroke(2.dp, colorResource(id = com.res.R.color.res_color_0f64e3)),
                    shape = RoundedCornerShape(6.dp)
                )
                .size(width = 311.dp, height = 42.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .nothing()
        }
        else -> {
            Modifier
                .border(
                    BorderStroke(2.dp, colorResource(id = com.res.R.color.res_color_D8E3ED)),
                    shape = RoundedCornerShape(6.dp)
                )
                .size(width = 311.dp, height = 42.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color.White)
                .nothing()
        }
    }

}