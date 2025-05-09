package logic.model

data class SuggestedClothes(
    val hour : Int? = null,
    val temperature : Double? = null,
    val timeOfDay : String? = null,
    val suggestionClothes : List<String>? = null
)
