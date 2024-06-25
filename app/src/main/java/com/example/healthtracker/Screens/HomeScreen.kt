package com.example.healthtracker.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthtracker.R
import com.example.healthtracker.ui.theme.RoyalPurple


@Composable
fun HomeScreen(navController: NavHostController) {

    val selectedDate by remember { mutableStateOf(ExerciseRepository.getDate(0)) }
    val caloriesInfo = ExerciseRepository.getCaloriesForDate(selectedDate)
    val kilometersRun = ExerciseRepository.getKmForDate(selectedDate, "run")
    val minutesRun = ExerciseRepository.getMinForDate(selectedDate, "run")
    val kilometersCycle = ExerciseRepository.getKmForDate(selectedDate, "cycle")
    val minutesCycle = ExerciseRepository.getMinForDate(selectedDate, "cycle")
    val kilometersHike = ExerciseRepository.getKmForDate(selectedDate, "hike")
    val minutesHike = ExerciseRepository.getMinForDate(selectedDate, "hike")
    val minutesTotal = ExerciseRepository.getTotalMinForDate(selectedDate)
    val kilometersTotal = ExerciseRepository.getTotalKmForDate(selectedDate)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoyalPurple)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    navController.navigate("profile")
                },
                modifier = Modifier.size(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile"
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                Text(
                    text = "Welcome",
                    Modifier.width(75.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp
                )

                Text(
                    text = "Berke Demir",
                    Modifier.width(100.dp),
                    color = Color.White,
                    fontSize = 17.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(70.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
                .clickable {
                    // navigate exercise
                }
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
                    Text(text = "$minutesRun min", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(56.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(text = "$kilometersRun km", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

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
                        Text(text = "${caloriesInfo.runCal} kcal", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
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
                .clickable {
                    // navigate exercise
                }
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
                    Text(text = "$minutesCycle min", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(56.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(text = "$kilometersCycle km", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

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
                        Text(text = "${caloriesInfo.cycleCal} kcal", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
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
                .clickable {
                    // navigate exercise
                }
        )
        {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hiking),
                    contentDescription = "Hiking",
                    modifier = Modifier.clip(CircleShape)
                        .size(width= 40.dp, height = 95.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column()
                {
                    Text(text = "Hiking", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "$minutesHike min", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(56.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                )
                {
                    Text(text = "$kilometersHike km", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)

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
                        Text(text = "${caloriesInfo.hikeCal} kcal", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        Color.White.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(16.dp),

                        )
                    .height(100.dp)
                    .size(130.dp)

            ) {
                Column {
                    Row(Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_heart),
                            contentDescription = "heart",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Heart Rate",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        modifier = Modifier.padding(start = 40.dp),
                        text = "—",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        Color.White.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(16.dp),

                        )
                    .height(100.dp)
                    .size(130.dp)

            ) {
                Column {
                    Row(Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_exercise),
                            contentDescription = "heart",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Exercise",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(Modifier.padding(start = 30.dp)) {
                        Text(
                            text = "$minutesTotal",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "min",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        Color.White.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(16.dp),

                        )
                    .height(100.dp)
                    .size(130.dp)

            ) {
                Column {
                    Row(Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_flag),
                            contentDescription = "flag",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "Distance",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(Modifier.padding(start = 30.dp)) {
                        Text(
                            text = "$kilometersTotal",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "km",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                    }
                }
            }
            Spacer(modifier = Modifier.width(20.dp))

            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        Color.White.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(16.dp),

                        )
                    .height(100.dp)
                    .size(130.dp)

            ) {
                Column {
                    Row(Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(25.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Calories",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(Modifier.padding(start = 30.dp)) {
                        Text(
                            text = "${caloriesInfo.totalCalories}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "kcal",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                    }
                }
            }
        }
    }
}
