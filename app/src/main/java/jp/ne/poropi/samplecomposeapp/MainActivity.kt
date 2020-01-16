package jp.ne.poropi.samplecomposeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    val context = +ambient(ContextAmbient)
    val image = +imageResource(R.drawable.header)
    MaterialTheme {
        val typography = +MaterialTheme.typography()
        Card(shape = RoundedCornerShape(8.dp)) {
            Column(
                modifier = Spacing(16.dp)
            ) {
                Container(modifier = Height(180.dp) wraps Expanded) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image = image)
                    }
                }

                HeightSpacer(height = 16.dp)

                Text("A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = typography.h6.withOpacity(0.87f))
                Text("Davenport, California",
                    style = typography.body2.withOpacity(0.87f))
                Text("December 2018",
                    style = typography.body2.withOpacity(0.6f))
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    NewsStory()
}

@Preview(widthDp = 320, heightDp = 480)
@Composable
fun DefaultPreview2() {
    NewsStory()
}
