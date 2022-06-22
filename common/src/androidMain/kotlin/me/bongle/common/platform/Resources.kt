package me.bongle.common.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import me.bongle.common.R

@Composable
actual fun painterResource(res: String): Painter {
    val id = drawableId(res)
    return androidx.compose.ui.res.painterResource(id)
}

// TODO: improve resource loading
private fun drawableId(res: String): Int {
    val imageName = res.substringAfterLast("/").substringBeforeLast(".")
    val drawableClass = R.drawable::class.java
    val field = drawableClass.getDeclaredField(imageName)
    val idValue = field.get(drawableClass) as Int
    return idValue.toInt()
}