package woowacourse.kanban.board

object TextValidator {
    fun validateTitle(title: String): Boolean = title.isEmpty()

    fun validateTag(tags: String): Boolean {
        if(tags.isNotEmpty()){
            val extractedTags = tags.split(",")
            return extractedTags.size < DefaultValue.MAX_TAGS || extractedTags.any { it.isNotEmpty() || it.length < DefaultValue.TAG_MAX_TEXT_LENGTH }
        }
        return true
    }
}