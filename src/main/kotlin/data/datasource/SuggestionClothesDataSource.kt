package data.datasource

import logic.model.Clothes

object SuggestionClothesDataSource {
    val clothesSuggestion: List<Clothes> = listOf(
        Clothes(name = "Coat 🧥", tags = listOf("freezing_temp", "morning", "night")),
        Clothes(name = "Scarf 🧣", tags = listOf("freezing_temp", "cold_temp", "night")),
        Clothes(name = "Gloves 🧤", tags = listOf("freezing_temp", "night")),
        Clothes(name = "Hat 👒", tags = listOf("freezing_temp", "cold_temp", "morning")),
        Clothes(name = "Jacket 🧥", tags = listOf("cold_temp", "morning")),
        Clothes(name = "Hoodie 👚", tags = listOf("cold_temp", "warm_temp", "morning", "night")),
        Clothes(name = "Boots 👢", tags = listOf("cold_temp", "morning")),
        Clothes(name = "Top 👚", tags = listOf("warm_temp", "morning")),
        Clothes(name = "Trousers 👖", tags = listOf("warm_temp", "night")),
        Clothes(name = "Dress 👗", tags = listOf("hot_temp", "morning")),
        Clothes(name = "Light Dress 👗", tags = listOf("hot_temp", "night")),
        Clothes(name = "T-Shirt 👕", tags = listOf("hot_temp", "warm_temp", "morning", "night")),
        Clothes(name = "Shorts 🩳", tags = listOf("hot_temp", "warm_temp", "morning"))
    )
}
