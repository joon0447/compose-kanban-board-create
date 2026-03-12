package woowacourse.kanban.board

object TextValidator {
    fun checkTitleIsEmpty(title: String): Boolean = title.isEmpty()

    fun checkNotValidTags(tags: String): Boolean {
        if(tags.isNotEmpty()){
            val extractedTags = tags.split(",")
            return extractedTags.size > DefaultValue.MAX_TAGS || extractedTags.any { it.isEmpty() || it.length > DefaultValue.TAG_MAX_TEXT_LENGTH }
        }
        return false
    }
}