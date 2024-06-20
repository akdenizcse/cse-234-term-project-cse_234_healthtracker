package com.example.healthtracker.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthtracker.R
import com.example.healthtracker.ui.theme.RoyalPurple
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@Composable
fun Profile() {
    var selectedDate by remember { mutableStateOf(getDate(0)) }
    val totalCaloriesToday = getCaloriesForDate(getDate(0))
    val calories = getCaloriesForDate(selectedDate)
    val kilometers = getKmForDate(selectedDate)
    val minutes = getMinForDate(selectedDate)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoyalPurple)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(

            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "close",
                    modifier = Modifier
                )
            }

            Spacer(modifier = Modifier.width(45.dp))

            Text(
                text = "Your Profile",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(45.dp))

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = "close",
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "profilePic",
            modifier = Modifier
                .clip(CircleShape)
                .size(128.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Berke Demir", fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.flame),
            contentDescription = "flame",
            modifier = Modifier
                .clip(CircleShape)
                .size(24.dp)
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(text = "$totalCaloriesToday", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(2.dp))

        Text(text = "Total Calories", fontSize = 12.sp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.timelineheadp),
            contentDescription = "timeline",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 1..5) {
                val buttonText = if (i == 3) "${getDate(i-3)}, Tdy" else getDate(i - 3)
                val textColor = if (i == 3) Color.White else Color.White.copy(alpha = 0.5f)

                TextButton(
                    onClick = { selectedDate = getDate(i-3) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp),
                    colors = ButtonDefaults.textButtonColors(contentColor = Color.Black),
                ) {
                    Text(
                        text = buttonText,
                        color = textColor,
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
        )
        {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.running),
                    contentDescription = "running",
                    modifier = Modifier.clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column()
                {
                    Text(text = "Running", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "$minutes min", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(56.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(text = "$kilometers km", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(16.dp)
                        )
                        Text(text = "$calories kcal", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
        )
        {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cycling),
                    contentDescription = "Cycling",
                    modifier = Modifier.clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column()
                {
                    Text(text = "Cycling", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "$minutes min", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(56.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(text = "$kilometers km", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(16.dp)
                        )
                        Text(text = "$calories kcal", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

fun getDate(offset: Int): String {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, offset)
    val format = SimpleDateFormat("dd", Locale.getDefault())
    return format.format(calendar.time)
}

fun getCaloriesForDate(date: String): Int {
    return when (date) {
        getDate(-2) -> 420
        getDate(-1) -> 300
        getDate(0) -> 501
        else -> 0
    }
}

fun getKmForDate(date: String): Int {
    return when (date) {
        getDate(-2) -> 5
        getDate(-1) -> 6
        getDate(0) -> 9
        else -> 0
    }
}
fun getMinForDate(date: String): Int {
    return when (date) {
        getDate(-2) -> 12
        getDate(-1) -> 15
        getDate(0) -> 32
        else -> 0
    }
}
