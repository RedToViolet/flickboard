package se.nullable.flickboard.model.layouts

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import se.nullable.flickboard.model.Action
import se.nullable.flickboard.model.Direction
import se.nullable.flickboard.model.KeyM
import se.nullable.flickboard.model.Layer
import se.nullable.flickboard.model.Layout
import se.nullable.flickboard.ui.FlickBoardParent
import se.nullable.flickboard.ui.Keyboard

val ES_MULTI_MAIN_LAYER = Layer(
    keyRows = listOf(
        listOf(
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("a"),
                    Direction.BOTTOM to Action.Text("å"),
                    Direction.BOTTOM_RIGHT to Action.Text("v"),
                    Direction.CENTER to Action.Text("a"),
                    Direction.TOP to Action.Text("å"),
                    Direction.TOP_RIGHT to Action.Text("ą"),
                    Direction.LEFT to Action.Text("ñ"),
                    Direction.BOTTOM to Action.Text("ä"),
                    Direction.BOTTOM_RIGHT to Action.Text("v"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("n"),
                    Direction.BOTTOM to Action.Text("l"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("i"),
                    Direction.TOP_LEFT to Action.Text("ę"),
                    Direction.TOP_RIGHT to Action.Text("ç"),
                    Direction.RIGHT to Action.Text("ń"),
                    Direction.BOTTOM_LEFT to Action.Text("x"),
                )
            ),
        ),
        listOf(
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("d"),
                    Direction.TOP to Action.Text("ć"),
                    Direction.RIGHT to Action.Text("k"),
                    Direction.BOTTOM to Action.Text("ö"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("o"),
                    Direction.TOP_LEFT to Action.Text("q"),
                    Direction.TOP to Action.Text("u"),
                    Direction.TOP_RIGHT to Action.Text("p"),
                    Direction.LEFT to Action.Text("c"),
                    Direction.RIGHT to Action.Text("b"),
                    Direction.BOTTOM_LEFT to Action.Text("g"),
                    Direction.BOTTOM to Action.Text("h"),
                    Direction.BOTTOM_RIGHT to Action.Text("j"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("r"),
                    Direction.LEFT to Action.Text("m"),
                )
            ),
        ),
        listOf(
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("t"),
                    Direction.TOP_RIGHT to Action.Text("y"),
                    Direction.BOTTOM_LEFT to Action.Text("ź"),
                    Direction.BOTTOM to Action.Text("ż"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("e"),
                    Direction.TOP to Action.Text("w"),
                    Direction.LEFT to Action.Text("ł"),
                    Direction.RIGHT to Action.Text("z"),
                )
            ),
            KeyM(
                actions = mapOf(
                    Direction.CENTER to Action.Text("s"),
                    Direction.TOP_LEFT to Action.Text("f"),
                    Direction.BOTTOM_RIGHT to Action.Text("ś"),
                )
            ),
        ),
        listOf(SPACE)
    )
)

val ES_MULTI = Layout(
    mainLayer = ES_MULTI_MAIN_LAYER,
    controlLayer = CONTROL_MESSAGEASE_LAYER
)

@Composable
@Preview
fun EsMultiKeyboardPreview() {
    FlickBoardParent {
        Keyboard(layout = Layout(ES_MULTI_MAIN_LAYER), onAction = {})
    }
}

@Composable
@Preview
fun EsMultiFullKeyboardPreview() {
    FlickBoardParent {
        Keyboard(layout = ES_MULTI, onAction = {})
    }
}
