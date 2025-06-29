package com.jdlstudios.jdldevbox.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jdlstudios.jdldevbox.data.remote.model.CategoryResponse
import com.jdlstudios.jdldevbox.ui.screens.metaconfig.MetaConfigViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(), // HomeViewModel now injects AppNavigator
    metaViewModel: MetaConfigViewModel = koinViewModel()
    // appNavigator ya no se inyecta aquí, se inyecta en HomeViewModel
) {
    val data by viewModel.categories.collectAsState()
    val metaData by metaViewModel.meta.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Welcome to JDL DevBox",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Meta Config: ${metaData.api.endpoints.frameworks}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        items(data.categories) { category ->
            CategoryCard(
                category = category,
                onClick = {
                    // Llamar a la función del ViewModel
                    viewModel.onCategoryClick(category.id)
                }
            )
        }
    }
}

@Composable
fun CategoryCard(category: CategoryResponse, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = category.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = category.description)
            Text(
                text = "ID: ${category.id}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Created At: ${category.color}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}
