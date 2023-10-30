package com.example.aluvery.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R
import com.example.aluvery.ui.theme.AluveryTheme
import com.example.aluvery.ui.theme.Purple500
import com.example.aluvery.ui.theme.Teal200

class ChallengeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengeCompose() {
    val imageSize = 100.dp
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .height(200.dp)
                .widthIn(300.dp, 350.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    modifier = Modifier
                        .size(imageSize)
                        .offset(x = imageSize / 2)
                        .align(Center)
                        .clip(shape = CircleShape)
                        .border(2.dp, Color.Cyan, CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Product Image"
                )
            }

            Spacer(modifier = Modifier.width(imageSize / 2))

            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .padding(16.dp)
                    .align(CenterVertically),
            ) {
                Column {
                    Text(
                        text = LoremIpsum(50).values.first(),
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 20.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreviewChallengeScrollCollum() {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .height(250.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Purple500, Teal200
                            )
                        )
                    )

            ) {
                Image(
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .align(BottomCenter)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Product Image"
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = "R$ 14,99",
                    fontWeight = FontWeight(400)
                )
            }

            Box(
                modifier = Modifier
                    .background(Color.LightGray)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            }
        }
    }
}