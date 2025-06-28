package com.jdlstudios.jdldevbox.ui.screens.metaconfig

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jdlstudios.jdldevbox.data.remote.model.MetaConfig
import com.jdlstudios.jdldevbox.ui.theme.JDLDevBoxTheme
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MetaConfigScreen(viewModel: MetaConfigViewModel = koinViewModel()) {
    // Observamos el StateFlow. Compose se redibujará cuando los datos lleguen.
    val metaInfo by viewModel.meta.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Acerca de JDLDevBox") })
        }
    ) { paddingValues ->
        // Si metaInfo es null, mostramos un indicador de carga.
        if (metaInfo == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            // Cuando los datos llegan, mostramos la lista de información.
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Card para la información del repositorio
                item {
                    InfoCard(title = "Repositorio") {
                        InfoRow(
                            icon = Icons.Default.Person,
                            label = "Nombre",
                            value = metaInfo!!.repository.name
                        )
                        InfoRow(
                            icon = Icons.Default.Info,
                            label = "Descripción",
                            value = metaInfo!!.repository.description
                        )
                        InfoRow(
                            icon = Icons.Default.Person,
                            label = "Autor",
                            value = metaInfo!!.repository.author
                        )
                        InfoRow(
                            icon = Icons.Default.Person,
                            label = "Licencia",
                            value = metaInfo!!.repository.license
                        )
                    }
                }

                // Card para las estadísticas
                item {
                    InfoCard(title = "Estadísticas de la Base de Datos") {
                        InfoRow(
                            icon = Icons.Default.AddCircle,
                            label = "Herramientas Totales",
                            value =
                                metaInfo!!.stats.totalTools.toString()
                        )
                        InfoRow(
                            icon = Icons.Default.Person, label = "Categorías", value =
                                metaInfo!!.stats.categoriesCount.toString()
                        )
                        InfoRow(
                            icon = Icons.Default.AddCircle,
                            label = "Tags",
                            value = metaInfo!!.stats.tagsCount.toString()
                        )
                    }
                }

                // Card para la versión
                item {
                    InfoCard(title = "Versión") {
                        InfoRow(
                            icon = Icons.Default.Person,
                            label = "Versión de Datos",
                            value = metaInfo!!.version
                        )
                        InfoRow(
                            icon = Icons.Default.Person,
                            label = "Última Actualización",
                            value = metaInfo!!.lastUpdated
                        )
                    }
                }
            }
        }
    }
}

// Composable reutilizable para las tarjetas de información
@Composable
private fun InfoCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            // El contenido específico de la tarjeta se inserta aquí
            content()
        }
    }
}

// Composable reutilizable para cada fila de información (Icono, Label, Valor)
@Composable
private fun InfoRow(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // Decorativo
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MetaConfigScreenPreview() {
    JDLDevBoxTheme {
        // Para el preview, necesitamos un MetaConfig de ejemplo
        val sampleMetaConfig = MetaConfig(
            version = "1.0.0",
            lastUpdated = "2025-06-24T00:00:00Z",
            totalTools = 2,
            repository = MetaConfig.Repository(
                name = "dev-tools-database",
                description = "Base de datos personal de herramientas de desarrollo",
                author = "tu-usuario",
                license = "MIT"
            ),
            api = MetaConfig.Api(
                baseUrl = "https://raw.githubusercontent.com/tu-usuario/dev-tools-database/main",
                endpoints = MetaConfig.Api.Endpoints(
                    categories = "/categories.json",
                    meta = "/meta.json",
                    allTools = "/tools/",
                    frameworks = "/tools/frameworks.json",
                    libraries = "/tools/libraries.json",
                    tools = "/tools/tools.json",
                    documentation = "/tools/documentation.json",
                    design = "/tools/design.json",
                    testing = "/tools/testing.json",
                    devops = "/tools/devops.json",
                    learning = "/tools/learning.json"
                )
            ),
            stats = MetaConfig.Stats(
                totalTools = 2,
                categoriesCount = 8,
                tagsCount = 21,
                lastSync = "2025-06-24T00:00:00Z"
            ),
            settings = MetaConfig.Settings(
                autoSync = true,
                syncInterval = 3600,
                cacheExpiry = 86400,
                maxRetries = 3
            )
        )
        // No podemos usar koinViewModel en el preview directamente, así que simulamos
        // un ViewModel con el MetaConfig de ejemplo.
        // Esto es solo para que el preview funcione.
        Column {
            Text(text = "Preview de MetaConfig", style = MaterialTheme.typography.headlineSmall)
            Text(text = "Version: ${sampleMetaConfig.version}")
            Text(text = "Base URL: ${sampleMetaConfig.api.baseUrl}")
        }
    }
}