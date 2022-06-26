package me.bongle.common.ui.layout.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BarItemWithAnime(
    painter: Painter,
    tint: Color,
    size: Dp = 25.dp,
    animDp: Dp = 6.dp,
    onClick: () -> Unit = {},
) {
    var isExpended by remember { mutableStateOf(false) }
    val expendSize by animateDpAsState(targetValue = if (isExpended) animDp else 0.dp)
    if (expendSize == animDp) {
        isExpended = false
    }
    Box(
        modifier = Modifier.clickable(
            onClick = {
                onClick()
                isExpended = true
            },
            enabled = true,
            role = Role.Button,
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ).size(size + animDp),
        contentAlignment = Alignment.Center
    ) {
        Icon(painter, contentDescription = "", Modifier.size(size + expendSize), tint = tint)
    }
}