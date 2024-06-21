package com.example.healthtracker.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoyalPurple)
            .padding(50.dp),
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
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
                .height(100.dp)
                .clickable {
                    // navigate exercise
                }

        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.running),
                    contentDescription = "running",
                    modifier = Modifier.clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(15.dp))

                Column() {
                    Text(
                        text = "Running",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "24 min", fontSize = 18.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.width(50.dp))

                Column() {
                    Text(
                        text = "5.56 km",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))

                        Text(text = "348 kcal", color = Color.White, fontSize = 15.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
                .height(100.dp)
                .clickable {
                    // navigate exercise
                }

        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cycling),
                    contentDescription = "running",
                    modifier = Modifier.clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(15.dp))

                Column() {
                    Text(
                        text = "Cycling",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "24 min", fontSize = 18.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.width(50.dp))

                Column() {
                    Text(
                        text = "4.22 km",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))

                        Text(text = "248 kcal", color = Color.White, fontSize = 15.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(48.dp))
                .height(100.dp)
                .clickable {
                    // navigate exercise
                }

        ) {
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hiking),
                    contentDescription = "hiking",
                    modifier = Modifier.clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(15.dp))

                Column() {
                    Text(
                        text = "Hiking",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(text = "24 min", fontSize = 18.sp, color = Color.White)
                }

                Spacer(modifier = Modifier.width(50.dp))

                Column() {
                    Text(
                        text = "5.56 km",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.flame),
                            contentDescription = "flame",
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))

                        Text(text = "348 kcal", color = Color.White, fontSize = 15.sp)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
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
                        fontWeight = FontWeight.Bold
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
                            text = "24",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "min",
                            color = Color.White,
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
                .padding(20.dp)
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
                            text = "10",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "km",
                            color = Color.White,
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
                            text = "42",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.width(3.dp))

                        Text(
                            text = "kcal",
                            color = Color.White,
                            fontSize = 15.sp
                        )

                    }
                }
            }
        }
    }
}