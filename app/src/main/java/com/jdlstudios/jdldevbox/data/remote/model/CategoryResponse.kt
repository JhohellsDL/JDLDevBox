package com.jdlstudios.jdldevbox.data.remote.model

data class CategoriesResponse(
    val version: String = "",
    val categories: List<CategoryResponse> = emptyList(),
    val tags: List<TagResponse> = emptyList()
)

data class CategoryResponse(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val path: String = "",
    val icon: String = "",
    val color: String = "",
    val subcategories: List<SubcategoryResponse> = emptyList()
) {
    override fun toString(): String {
        return "Category(id='$id', name='$name', description='$description', icon='$icon', color='$color')"
    }
}

data class SubcategoryResponse(
    val id: String = "",
    val name: String = "",
) {
    override fun toString(): String {
        return "Subcategory(id='$id', name='$name')"
    }
}

data class TagResponse(
    val name: String = "",
    val color: String = ""
) {
    override fun toString(): String {
        return "TagResponse(name='$name', color='$color')"
    }
}