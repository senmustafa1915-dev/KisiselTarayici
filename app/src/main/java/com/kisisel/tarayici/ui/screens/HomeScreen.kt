package com.kisisel.tarayici.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kisisel.tarayici.ui.theme.*

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
            
            // Üst Başlık
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

            // Arama Çubuğu
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CardDark, RoundedCornerShape(24.dp))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Search, contentDescription = "Ara", tint = TextGray)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Search or enter address", color = TextGray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Kısayollar
            Text("Shortcuts", color = TextGray, fontSize = 14.sp, modifier = Modifier.align(Alignment.Start))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ShortcutIcon("Netflix", "N", Color(0xFFE50914))
                ShortcutIcon("Dizipal", "D", Color(0xFFE53935))
                ShortcutIcon("Yandex", "Y", Color(0xFFFF0000))
                ShortcutIcon("Film", "F", CardDark)
            }
        }

        // Alttaki Menü Çubuğu (Bottom Bar)
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .background(CardDark, RoundedCornerShape(30.dp))
                .padding(horizontal = 24.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Home, "Ana Sayfa", tint = Color.White, modifier = Modifier.clickable { })
            Icon(Icons.Default.Public, "Tarayıcı", tint = TextGray, modifier = Modifier.clickable { })
            Icon(Icons.Default.AddCircle, "Yeni Sekme", tint = NeonPurple, modifier = Modifier.size(32.dp).clickable { })
            Icon(Icons.Default.ContentCopy, "Sekmeler", tint = TextGray, modifier = Modifier.clickable { })
            Icon(Icons.Default.Menu, "Menü", tint = TextGray, modifier = Modifier.clickable { showBottomSheet = true })
        }

        // Alttan Açılan Panel (Bottom Sheet)
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState,
                containerColor = DarkSurface,
                dragHandle = { BottomSheetDefaults.DragHandle(color = TextGray) }
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    // Reklam Engelleyici Sayaç Kartı
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(CardDark, RoundedCornerShape(16.dp))
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Shield, "Kalkan", tint = NeonPurple, modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text("3,485", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text("Ads Blocked", color = TextGray, fontSize = 12.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Menü Butonları
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                        MenuButton(Icons.Default.History, "History")
                        MenuButton(Icons.Default.Bookmark, "Bookmarks")
                        MenuButton(Icons.Default.Download, "Downloads")
                        MenuButton(Icons.Default.Settings, "Settings")
                    }
                    
                    Spacer(modifier = Modifier.height(32.dp))

                    // Çıkış Butonu
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF331111), RoundedCornerShape(16.dp))
                            .clickable { showBottomSheet = false }
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.ExitToApp, "Çıkış", tint = Color.Red)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Exit Browser", color = Color.Red, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Composable
fun ShortcutIcon(name: String, initial: String, bgColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(bgColor),
            contentAlignment = Alignment.Center
        ) {
            Text(initial, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Text(name, color = TextGray, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun MenuButton(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(CardDark, RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = text, tint = NeonPurple)
        }
        Text(text, color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(top = 8.dp))
    }
}
