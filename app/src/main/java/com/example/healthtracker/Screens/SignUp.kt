package com.example.healthtracker.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.healthtracker.R
import com.example.healthtracker.ui.theme.RoyalPurple
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

@Composable
fun SignUp(navController: NavHostController) {
    val auth = Firebase.auth

    var nameSignState by remember {
        mutableStateOf("")
    }

    var surnameSignState by remember {
        mutableStateOf("")
    }

    var emailSignState by remember {
        mutableStateOf("")
    }

    var passwordSignState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RoyalPurple)
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Health Tracker",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Track your health effortlessly!",
            fontSize = 15.sp,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp)
        )
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Enter your email and password to sign up",
                    fontSize = 17.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = nameSignState,
                    onValueChange = {
                        nameSignState = it
                    },
                    label = {
                        Text(text = "Name")
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = surnameSignState,
                    onValueChange = {
                        surnameSignState = it
                    },
                    label = {
                        Text(text = "Surname")
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = emailSignState,
                    onValueChange = {
                        emailSignState = it
                    },
                    label = {
                        Text(text = "Email")
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = passwordSignState,
                    onValueChange = {
                        passwordSignState = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        auth.createUserWithEmailAndPassword(emailSignState, passwordSignState)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val user = auth.currentUser
                                    user?.let {
                                        // Store additional user information in Firestore
                                        val db = Firebase.firestore
                                        val userDocument = db.collection("users").document(user.uid)
                                        val userData = hashMapOf(
                                            "name" to nameSignState,
                                            "surname" to surnameSignState,
                                            "email" to emailSignState

                                        )
                                        userDocument.set(userData)
                                            .addOnSuccessListener {

                                            }
                                            .addOnFailureListener { e ->

                                            }
                                    }
                                    navController.navigate("home_screen")

                                } else {
                                    // hata mesaj
                                }
                            }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3C005A),
                        contentColor = Color.White
                    ),

                    )
                {
                    Text(text = "Sign up with email")
                }

                Spacer(modifier = Modifier.height(15.dp))


                Text(
                    text = "By clicking continue, you agree to our Terms of Service and Privacy Policy",
                    fontSize = 17.sp,
                    color = Color.White,
                    modifier = Modifier.clickable {

                    }
                )

            }
        }
    }
}