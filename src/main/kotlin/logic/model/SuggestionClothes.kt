package logic.model

data class SuggestionClothes(
    val hour:Int,
    val temperature:Double,
    val timeOfDay:String,
    val suggestionClothes : List<String>
)
