package logic.uitls

import logic.model.Clothes

object DataSource {
    val clothesSuggestion = listOf(
        Clothes(nameOfClothes = "Coat 🧥", tags = listOf("freezing_temp", "morning", "night")),
        Clothes(nameOfClothes = "Scarf 🧣", tags = listOf("freezing_temp", "cold_temp", "night")),
        Clothes(nameOfClothes = "Gloves 🧤", tags = listOf("freezing_temp", "night")),
        Clothes(nameOfClothes = "Hat 👒", tags = listOf("freezing_temp", "cold_temp", "morning")),
        Clothes(nameOfClothes = "Jacket 🧥", tags = listOf("cold_temp", "morning")),
        Clothes(nameOfClothes = "Hoodie 👚", tags = listOf("cold_temp", "warm_temp", "morning", "night")),
        Clothes(nameOfClothes = "Boots 👢", tags = listOf("cold_temp", "morning")),
        Clothes(nameOfClothes = "Top 👚", tags = listOf("warm_temp", "morning")),
        Clothes(nameOfClothes = "Trousers 👖", tags = listOf("warm_temp", "night")),
        Clothes(nameOfClothes = "Dress 👗", tags = listOf("hot_temp", "morning")),
        Clothes(nameOfClothes = "Light Dress 👗", tags = listOf("hot_temp", "night")),
        Clothes(nameOfClothes = "T-Shirt 👕", tags = listOf("hot_temp", "warm_temp", "morning", "night")),
        Clothes(nameOfClothes = "Shorts 🩳", tags = listOf("hot_temp", "warm_temp", "morning"))
    )
}
