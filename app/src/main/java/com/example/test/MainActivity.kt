package com.example.test


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.model.Tarefa.Tarefa
import com.example.test.ui.theme.TestTheme
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
        }
    }
}

@Composable
fun MainScreenContent(drawerState: DrawerState) {
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "Gerenciador de Tarefa") },
                backgroundColor = Color(0xFF617A55), // Adicione a cor desejada aqui
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Drawer Menu"
                        )
                    }
                },
            )
        },
        drawerBackgroundColor = Color(0xFFE1ECC8),
        drawerGesturesEnabled = drawerState.isOpen,
        drawerContent = {

            Column(
                modifier = Modifier.align(Alignment.CenterHorizontally)

                    .padding(16.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Informações",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 24.sp
                )


            }
            Column(
                modifier = Modifier.padding(2.dp)
            ) {
                Box(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.bruno),
                        contentDescription = "Descrição da imagem",
                        modifier = Modifier
                            .size(400.dp)
                            .clip(CircleShape)
                            .scale(1.35f)
                            .fillMaxSize()
                            .padding(2.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Ícone de info",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "RM: 22295",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "BRUNO SANTOS PORTUGAL",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Ícone de Home",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "ETEC ZONA LESTE",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Ícone de Home",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "DESENVOLVIMENTO DE SISTEMAS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }


            }
        },

                content = { paddingValues ->
            Log.i("paddingValues", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color(0xFFA0C49D))
                    .fillMaxSize()
            ) {
                MySearchField(modifier = Modifier.fillMaxWidth())

                val tProvaDeCalculo = Tarefa(
                    "Estudar prova de Calculo",
                    "Capitulo 5 do livro 'O Último Teorema de Fermat'",
                    Date(),
                    Date(),
                    status = 0.0,
                )


                val tProvaDeKotlin = Tarefa(
                    "Estudar prova de Kotlin",
                    "Material de Jetpack Compose",
                    Date(),
                    Date(),
                    status = 0.0
                )
                val tProvaDePWII = Tarefa(
                    "Estudar prova de PWII",
                    "Documentação de Laravel",
                    Date(),
                    Date(),
                    status = 0.0
                )
                val tProvaDePAM = Tarefa(
                    "Estudar prova de PAM",
                    "Documentação do Android Studio",
                    Date(),
                    Date(),
                    status = 0.0
                )
                val tProvaDeBD = Tarefa(
                    "Estudar prova de BD",
                    "Crud com MySQL",
                    Date(),
                    Date(),
                    status = 0.0
                )
                val minhaListaDeTarefas = listOf<Tarefa>(tProvaDeCalculo, tProvaDeKotlin, tProvaDePWII,tProvaDePAM,tProvaDeBD)

                MyTaskWidgetList(minhaListaDeTarefas)
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(0xFF617A55),
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "@Feito por Bruno Portugal",
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                }
            )
        },
        isFloatingActionButtonDocked = false,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color(0xFF617A55)
            ) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add Task"
                )
            }
        },

    )

}





@Composable
fun MyTaskWidgetList(listaDeTarefas: List<Tarefa>) {
    listaDeTarefas.forEach { tarefa ->
        MyTaskWidget(modifier = Modifier.fillMaxWidth(), tarefaASerMostrada = tarefa)
    }
}

@Composable
fun MySearchField(modifier: Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier,
        placeholder = { Text(text = "Pesquisar tarefas ") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.Black // Aqui você pode definir a cor desejada, como Color.Red
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFE1ECC8), // Cor de fundo do TextField
         // Cor da borda quando o TextField não está em foco
            cursorColor = Color.Black, // Cor do cursor dentro do TextField
            textColor = Color.Black, // Cor do texto dentro do TextField
            placeholderColor = Color.Black // Cor do texto do placeholder
        )
    )
}


@Composable
fun MyTaskWidget(
    modifier: Modifier,
    tarefaASerMostrada: Tarefa
) {
    val dateFormatter = SimpleDateFormat("EEE, MMM dd, yyyy", Locale.getDefault())


    Row(modifier = modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {


        Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre o ícone e o texto

        Column(modifier = Modifier.weight(1f)) {
            Row(modifier = modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icons of a pending task",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 5.dp),
                    tint = Color(0xFF617A55)
                    // Cor do ícone
                )

                Text(
                    text = dateFormatter.format(tarefaASerMostrada.pzoFinal),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 12.sp,
                    color = Color.Black,// Cor do texto da data

                )
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp)
                    .clickable{ },
            elevation = 4.dp, // Elevação da sombra
                backgroundColor = Color(0xFFC4D7B2)// Cor de fundo do Card
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = tarefaASerMostrada.nome,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        color = Color.Black // Cor do texto do nome da tarefa
                    )

                    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontStyle = FontStyle.Normal
                                    )
                                ) {
                                    append(tarefaASerMostrada.datalhes.toString())
                                }
                            },
                            fontSize = 12.sp,
                            color = Color(0xFF413F42), // Cor do texto dos detalhes da tarefa
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        MainScreenContent(DrawerState(initialValue = DrawerValue.Closed))
    }
}

