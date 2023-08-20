package com.example.scorestream.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.scorestream.onboarding.R

@Composable
fun GreetingScreen(
    navigateToLiveScore: () -> Unit
) {
    val composition =
        rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.greeting_background))
    val progress by animateLottieCompositionAsState(
        composition = composition.value, iterations = LottieConstants.IterateForever
    )
    Box(contentAlignment = Alignment.BottomCenter) {
        LottieAnimation(
            modifier = Modifier.fillMaxSize(),
            composition = composition.value,
            progress = { progress },
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(bottom = 70.dp)
                .padding(horizontal = 40.dp),
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.application_name),
                style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold, color = Color.White)
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.app_sloagan),
                style = MaterialTheme.typography.bodyLarge, color = Color.White
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                onClick = navigateToLiveScore,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF003355),
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(R.string.start_now))
            }
        }
    }

}