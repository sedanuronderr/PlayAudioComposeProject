package com.seda.playaudiocomposeproject

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seda.playaudiocomposeproject.ui.theme.PlayAudioComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayAudioComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PlayAudio(this)
                }
            }
        }
    }


}
@Composable
fun PlayAudio(context: Context){

    val mp:MediaPlayer = MediaPlayer.create(context,R.raw.music)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
        Image(painter = painterResource(id = R.drawable.music_note_24), contentDescription = "",
             modifier = Modifier
                 .height(260.dp)
                 .width(260.dp)
                 .padding(32.dp)
                 .background(Color.Black)
            )
            
       Row {
           IconButton(onClick = { mp.start() }, modifier = Modifier
               .height(65.dp)
               .width(65.dp)) {
               Icon(painter = painterResource(id = R.drawable.play), contentDescription ="" )
           }

           IconButton(onClick = { mp.pause() }, modifier = Modifier.size(65.dp)) {
               Icon(painter = painterResource(id = R.drawable.pause), contentDescription ="" )

           }
       }

    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlayAudioComposeProjectTheme {

    }
}