package com.dergoogler.mmrl.ui.component.listItem.dsl.component.item

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dergoogler.mmrl.ext.toStyleMarkup
import com.dergoogler.mmrl.ui.component.listItem.dsl.ListItemScope

/**
 * A description for the list item.
 *
 * This composable function is used to display a description within a list item.
 * It applies a specific text style (bodyMedium with outline color) to the content.
 *
 * @param content A composable lambda that defines the content of the description.
 *                This lambda is executed within a [BoxScope], allowing for flexible layout options.
 */
@Composable
fun ListItemScope.Description(content: @Composable BoxScope.() -> Unit) {
    val style = MaterialTheme.typography.bodyMedium.copy(
        color = MaterialTheme.colorScheme.outline
    )

    Box(modifier = Modifier.description()) {
        ProvideTextStyle(style) {
            content()
        }
    }
}


/**
 * A description for the list item.
 *
 * @param text The description text. Supports style markup.
 */
@Composable
fun ListItemScope.Description(text: String) {
    this.Description {
        Text(text.toStyleMarkup())
    }
}


/**
 * A description for the list item.
 *
 * @param id The string resource ID for the description text.
 */
@Composable
fun ListItemScope.Description(
    @StringRes id: Int,
) = this.Description(stringResource(id))
