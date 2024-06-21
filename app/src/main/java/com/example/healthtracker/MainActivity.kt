package com.example.healthtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthtracker.Navigation.Nav
import com.example.healthtracker.Screens.HomeScreen
import com.example.healthtracker.Screens.Profile
import com.example.healthtracker.ui.theme.Pink40
import com.example.healthtracker.ui.theme.Pink80
import com.example.healthtracker.ui.theme.RoyalPurple

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nav()
        }
    }


}

@Preview(showBackground = true)
@Composable
fun test() {
    Box(
        modifier = Modifier
            .background(RoyalPurple)
            .fillMaxSize()
    )

    {

        Card(
            shape = RoundedCornerShape(24.dp), modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp)
                .size(50.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Pink80)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.running_icon_26700),
                    contentDescription = "running"


                )

            }
        }
    }


}






