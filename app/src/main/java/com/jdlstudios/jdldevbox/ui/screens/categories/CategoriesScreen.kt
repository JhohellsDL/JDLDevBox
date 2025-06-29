package com.jdlstudios.jdldevbox.ui.screens.categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.tooling.preview.Preview
import com.jdlstudios.jdldevbox.data.remote.model.ToolResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesScreen(tools: List<ToolResponse>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Herramientas de Desarrollo") }
            )
        }
    ) { paddingValues ->
        if (tools.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No hay herramientas para mostrar.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(tools.size) { tool ->
                    ToolCard(tool = tools[tool])
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun ToolCard(tool: ToolResponse) {
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = tool.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tool.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Rating and Popularity
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Rating",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${tool.rating} / 5.0",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Popularidad: ${tool.popularity.replaceFirstChar { it.uppercase() }}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Tags
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                tool.tags.forEach { tag ->
                    AssistChip(
                        onClick = { /* Handle tag click if needed */ },
                        label = { Text(tag) },
                        modifier = Modifier.height(32.dp) // Adjust chip height
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            // Links
            Text(
                text = "Enlaces:",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            LinkText(label = "Oficial", url = tool.officialUrl, uriHandler = uriHandler)
            LinkText(label = "Documentación", url = tool.documentationUrl, uriHandler = uriHandler)
            LinkText(label = "GitHub", url = tool.githubUrl, uriHandler = uriHandler)
        }
    }
}

@Composable
private fun LinkText(label: String, url: String, uriHandler: UriHandler) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = url,
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
            modifier = Modifier.clickable { uriHandler.openUri(url) }
        )
    }
}

@Composable
@Preview
private fun ToolsScreenPreview() {
    val sampleTools = listOf(
        ToolResponse(
            id = "react-001",
            name = "React",
            description = "Biblioteca de JavaScript para construir interfaces de usuario",
            url = "https://reactjs.org/",
            officialUrl = "https://reactjs.org/",
            documentationUrl = "https://reactjs.org/docs/getting-started.html",
            githubUrl = "https://github.com/facebook/react",
            tags = listOf("javascript", "frontend", "ui", "spa", "popular"),
            category = "frameworks",
            subcategory = "frontend",
            language = "javascript",
            rating = 4.8,
            popularity = "high",
            learningCurve = "medium",
            dateAdded = "2025-06-24T00:00:00Z",
            lastUpdated = "2025-06-24T00:00:00Z",
            recommendedBy = "equipo-frontend",
            notes = "Muy popular para SPAs, gran ecosistema",
            useCases = listOf("web apps", "mobile apps con React Native"),
            alternatives = listOf("Vue.js", "Angular", "Svelte"),
            isActive = true,
            license = "MIT",
            company = "Meta"
        )
    )
    CategoriesScreen(tools = sampleTools)
}
