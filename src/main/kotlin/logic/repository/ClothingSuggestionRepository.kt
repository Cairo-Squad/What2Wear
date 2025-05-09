package logic.repository

import logic.model.Clothes

interface ClothingSuggestionRepository {
    fun getAllClothes(): List<Clothes>
}