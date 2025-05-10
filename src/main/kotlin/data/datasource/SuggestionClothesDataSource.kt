package data.datasource

import logic.model.Clothes
import logic.usecase.WeatherConstants
import logic.utils.NoClothesFoundException

class SuggestionClothesDataSource {
    private val clothesSuggestion: List<Clothes> = listOf(
        Clothes(name = "Coat 🧥", tags = listOf(WeatherConstants.FREEZING_TAG, WeatherConstants.MORNING, WeatherConstants.NIGHT)),
        Clothes(name = "Scarf 🧣", tags = listOf(WeatherConstants.FREEZING_TAG, WeatherConstants.COLD_TAG, WeatherConstants.NIGHT)),
        Clothes(name = "Gloves 🧤", tags = listOf(WeatherConstants.FREEZING_TAG, WeatherConstants.NIGHT)),
        Clothes(name = "Hat 👒", tags = listOf(WeatherConstants.FREEZING_TAG, WeatherConstants.COLD_TAG, WeatherConstants.MORNING)),
        Clothes(name = "Jacket 🧥", tags = listOf(WeatherConstants.COLD_TAG, WeatherConstants.MORNING)),
        Clothes(name = "Hoodie 👚", tags = listOf(WeatherConstants.COLD_TAG, WeatherConstants.WARM_TAG, WeatherConstants.MORNING, WeatherConstants.NIGHT)),
        Clothes(name = "Boots 👢", tags = listOf(WeatherConstants.COLD_TAG, WeatherConstants.MORNING)),
        Clothes(name = "Top 👚", tags = listOf(WeatherConstants.WARM_TAG, WeatherConstants.MORNING)),
        Clothes(name = "Trousers 👖", tags = listOf(WeatherConstants.WARM_TAG, WeatherConstants.NIGHT)),
        Clothes(name = "Dress 👗", tags = listOf(WeatherConstants.HOT_TAG, WeatherConstants.MORNING)),
        Clothes(name = "Light Dress 👗", tags = listOf(WeatherConstants.HOT_TAG, WeatherConstants.NIGHT)),
        Clothes(name = "T-Shirt 👕", tags = listOf(WeatherConstants.HOT_TAG, WeatherConstants.WARM_TAG, WeatherConstants.MORNING, WeatherConstants.NIGHT)),
        Clothes(name = "Shorts 🩳", tags = listOf(WeatherConstants.HOT_TAG, WeatherConstants.WARM_TAG, WeatherConstants.MORNING))
    )
    fun filterClothes(weatherTag : List<String>) : List<String>? {
        return clothesSuggestion
            .filter { clothes -> weatherTag.all { tag -> clothes.tags.contains(tag.lowercase()) } }
            .map { it.name }
            .takeIf { it.isNotEmpty()
            }
    }
}
