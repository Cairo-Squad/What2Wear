package data.repository

interface SuggestionClothesDataSource {
    fun filterClothes(weatherTag : List<String>) : List<String>?
}