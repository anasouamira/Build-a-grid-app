package com.example.buildagridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.buildagridapp.model.Topic
import com.example.buildagridapp.ui.theme.BuildAGridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuildAGridAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GridApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GridApp(modifier: Modifier = Modifier){
}

fun TopicList(topics : List<Topic>){

    val totalTopic = topics.size




}

@Composable
fun TopicCard(topic : Topic, modifier : Modifier = Modifier){
        Card(modifier = modifier){
            Row() {
                Image(
                    modifier = Modifier.weight(1f),
                    painter = painterResource(topic.drawableRes),
                    contentDescription = stringResource(topic.stringResources)
                )
                Column(modifier = Modifier.weight(2f)) {
                    Text(
                        text = stringResource(topic.stringResources)
                    )
                    Text(
                        text = topic.numberOfPic.toString()
                    )
                }
            }
        }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildAGridAppTheme {
        TopicCard(Topic(R.string.film,123,R.drawable.film))
    }
}