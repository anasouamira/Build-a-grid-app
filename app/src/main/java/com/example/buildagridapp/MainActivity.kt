package com.example.buildagridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buildagridapp.data.DataResources
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

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        val dataResources : List<Topic> = DataResources.topics
        TopicList(dataResources)
    }


}

@Composable
fun TopicList(topics : List<Topic>){

    LazyColumn(modifier = Modifier.background(Color.Gray)) {
        items(topics.chunked(2)){rowTopic ->
            Row(modifier = Modifier.fillMaxWidth()) {
                rowTopic.forEach { topic ->
                    TopicCards(topic, Modifier.weight(1f))
                }
            }

        }
    }




}

@Composable
fun TopicCards(topic : Topic, modifier : Modifier = Modifier){
    Card(
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(topic.drawableRes),
                contentDescription = stringResource(topic.stringResources),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )

            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(topic.stringResources))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = topic.numberOfPic.toString())
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuildAGridAppTheme {
        TopicList(DataResources.topics)
    }
}