package com.example.sodateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sodateapp.ui.theme.SodateAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SodateAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GrowPlantScreen()
                }
            }
        }
    }
}

@Composable
fun GrowPlantScreen() {
    var growthStage by remember { mutableStateOf(0) }
    val stage = growthStage.coerceIn(0, 3)

    val plantImage = when (stage) {
        0 -> R.drawable.plant_stage_0
        1 -> R.drawable.plant_stage_1
        2 -> R.drawable.plant_stage_2
        else -> R.drawable.plant_stage_3
    }

    val stageText = when (stage) {
        0 -> "まだ芽が出ていないよ"
        1 -> "芽が出たよ！"
        2 -> "ぐんぐん育ってる！"
        else -> "おおきくなった！"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "みずをあげて そだてよう！",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFFFFF1E6)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = plantImage),
                        contentDescription = "植物",
                        modifier = Modifier.size(220.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stageText,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                        .height(36.dp)
                        .fillMaxWidth(0.7f)
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color(0xFF9A6A4F))
                )
            }
        }

        Button(
            onClick = { if (growthStage < 3) growthStage += 1 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5CC8FF)),
            contentPadding = PaddingValues(horizontal = 28.dp, vertical = 12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.water_drop),
                contentDescription = "みず",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "みずをかける")
        }
    }
}
