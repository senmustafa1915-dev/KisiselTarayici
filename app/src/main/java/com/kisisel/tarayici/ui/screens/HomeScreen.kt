package com.kisisel.tarayici.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val OledBlack = Color(0xFF000000)
val CardDark = Color(0xFF1E1E1E)
val NeonPurple = Color(0xFFBB86FC)
val TextGray = Color(0xFFAAAAAA)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OledBlack)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            
            Text(
                text = "N E X A",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 4.sp
            )
            Text(
                text = "Browse. Private. Yours.",
                color = TextGray,
                fontSize = 12.sp
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardDark, RoundedCornerShape(24.dp))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Search or enter address", color = TextGray, fontSize = 14.sp)
            }
            
            Spacer(modifier = Modifier.height(40.dp))
            
            Button(onClick = { showBottomSheet = true }) {
                Text("Menüyü Aç")
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                containerColor = CardDark
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Menü (Yapım Aşamasında)", color = Color.White)
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}
