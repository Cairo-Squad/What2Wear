package data.repository

import data.datasource.SuggestionClothesDataSource
import logic.model.Clothes
import logic.repository.ClothingSuggestionRepository

class ClothingSuggestionRepositoryImpl: ClothingSuggestionRepository {
    override fun getAllClothes(): List<Clothes> {
        return SuggestionClothesDataSource.clothesSuggestion
    }
}