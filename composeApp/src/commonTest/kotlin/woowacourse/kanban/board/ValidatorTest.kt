package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidatorTest {
    @Test
    fun `제목에 빈 값이 들어오면 checkTitleIsEmpty가 true를 반환한다`() {
        assertTrue { Validator.checkTitleIsEmpty("") }
    }

    @Test
    fun `태그의 개수가 5개 초과하면 checkNotValidTags가 true를 반환한다`() {
        assertTrue { Validator.checkNotValidTags("태그, 태그, 태그, 태그, 태그, 태그") }
    }

    @Test
    fun `태그 당 텍스트 글자 수가 5자를 초과하면 checkNotValidTags가 true를 반환한다`() {
        assertTrue { Validator.checkNotValidTags("5글자 이상 태그") }
    }

    @Test
    fun `제목에 값이 입력되면 checkTitleIsEmpty가 false를 반환한다`() {
        assertFalse { Validator.checkTitleIsEmpty("제목 있음") }
    }

    @Test
    fun `태그에 빈 값이 입력되면 checkNotValidTags가 false를 반환한다`() {
        assertFalse { Validator.checkNotValidTags("") }
    }

    @Test
    fun `태그별 텍스트가 비어있으면 checkNotValidTags가 true를 반환한다`() {
        assertTrue { Validator.checkNotValidTags(",태그") }
    }

    @Test
    fun `모든 태그의 텍스트 글자 수가 5자 이하이면 checkNotValidTags가 false를 반환한다`() {
        assertFalse { Validator.checkNotValidTags("태그, 태그, 태그, 태그, 태그") }
    }

    @Test
    fun `제목이 입력되면 checkButtonEnabled가 true를 반환한다`() {
        val title = "제목"
        val isTitleEmpty = Validator.checkTitleIsEmpty(title)
        val tags = ""
        val isNotValidTag = Validator.checkNotValidTags(tags)

        assertTrue { Validator.checkButtonEnable(isTitleEmpty, isNotValidTag) }
    }

    @Test
    fun `제목이 입력되지 않으면 checkButtonEnable가 false를 반환한다`() {
        val title = ""
        val isTitleEmpty = Validator.checkTitleIsEmpty(title)
        val tags = ""
        val isNotValidTag = Validator.checkNotValidTags(tags)

        assertFalse { Validator.checkButtonEnable(isTitleEmpty, isNotValidTag) }
    }

    @Test
    fun `태그가 5개 초과면 checkButtonEnable가 false를 반환한다`() {
        val title = "제목"
        val isTitleEmpty = Validator.checkTitleIsEmpty(title)
        val tags = "1,2,3,4,5,6"
        val isNotValidTag = Validator.checkNotValidTags(tags)

        assertFalse { Validator.checkButtonEnable(isTitleEmpty, isNotValidTag) }
    }

    @Test
    fun `한 태그의 글자 수가 5자 초과면 checkButtonEnable가 false를 반환한다`() {
        val title = "제목"
        val isTitleEmpty = Validator.checkTitleIsEmpty(title)
        val tags = "5글자 초과 태그"
        val isNotValidTag = Validator.checkNotValidTags(tags)

        assertFalse { Validator.checkButtonEnable(isTitleEmpty, isNotValidTag) }
    }

    @Test
    fun `제목이 입력되고 태그의 개수가 5개 이하이며 한 태그당 글자 수가 5자 이하면 checkButtonEnable가 true를 반환한다`() {
        val title = "제목"
        val isTitleEmpty = Validator.checkTitleIsEmpty(title)
        val tags = "태그1,태그2,태그3,태그4,태그5"
        val isNotValidTag = Validator.checkNotValidTags(tags)

        assertTrue { Validator.checkButtonEnable(isTitleEmpty, isNotValidTag) }
    }
}
