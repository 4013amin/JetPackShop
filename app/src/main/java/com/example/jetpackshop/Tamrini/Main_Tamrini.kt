package com.example.jetpackshop.Tamrini

import android.annotation.SuppressLint
import android.net.http.HttpException
import android.os.Build
import android.os.Bundle
import android.widget.Scroller
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackshop.Tamrini.data.api.api_inter
import com.example.jetpackshop.Tamrini.data.models.Models_TamriniItem
import com.example.jetpackshop.Tamrini.data.utils.retrofit_Inter
import com.example.jetpackshop.shop.MyForm
import com.example.jetpackshop.shop.data.models.Users_ModelItem
import com.example.jetpackshop.ui.theme.JetPackShopTheme
import java.io.IOException

class Main_Tamrini : androidx.activity.ComponentActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackShopTheme {
                Get_data_tamrini()
            }
        }
    }
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun Get_data_tamrini() {
    var userlist by remember {
        mutableStateOf(listOf<Models_TamriniItem>())
    }

    var scope = rememberCoroutineScope()
    var scroller = rememberScrollState()
    LaunchedEffect(key1 = true) {
        var response = try {
            retrofit_Inter.api.get_data_tamrini()
        } catch (e: IOException) {
            return@LaunchedEffect
        } catch (e: HttpException) {
            return@LaunchedEffect
        }
        if (response.isSuccessful && response.body() != null) {
            userlist = response.body()!!
        }
    }
    single_items(userlis = userlist)

}

//@Composable
//fun lazy(userlis: List<Models_TamriniItem>, scroller: ScrollState) {
//    LazyColumn(modifier = Modifier.fillMaxWidth()) {
//        items(userlis.size) {
//            single_items(userlis)
//        }
//    }
//}

@Composable
fun single_items(userlis: List<Models_TamriniItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState()
    ) {
        items(userlis) { user ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(5.dp)
            ) {
                Text(text = "Title : ${user.title}", fontSize = 18.sp, color = Color.Black)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun show_tamrini() {

}