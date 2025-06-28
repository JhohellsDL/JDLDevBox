package com.jdlstudios.jdldevbox.data.remote.model

data class CategoryResponse(
    val categories: List<Category> = emptyList()
)

data class Category(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val icon: String = "",
    val color: String = "",
    val subcategories: List<Subcategory> = emptyList()
) {
    override fun toString(): String {
        return "Category(id='$id', name='$name', description='$description', icon='$icon', color='$color')"
    }
}

data class Subcategory(
    val id: String = "",
    val name: String = "",
) {
    override fun toString(): String {
        return "Subcategory(id='$id', name='$name')"
    }
}
