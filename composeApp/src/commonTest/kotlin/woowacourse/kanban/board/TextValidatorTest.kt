package woowacourse.kanban.board

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TextValidatorTest {
    @Test
    fun `제목에 빈 값이 들어오면 true를 반환한다`() {
        assertTrue { TextValidator.checkTitleIsEmpty("") }
    }

    @Test
    fun `태그의 개수가 5개 초과하면 true를 반환한다`() {
        assertTrue { TextValidator.checkNotValidTags("태그, 태그, 태그, 태그, 태그, 태그") }
    }

    @Test
    fun `태그 당 텍스트 글자 수가 5자를 초과하면 true를 반환한다`() {
        assertTrue { TextValidator.checkNotValidTags("5글자 이상 태그") }
    }

    @Test
    fun `제목에 값이 입력되면 false를 반환한다`() {
        assertFalse { TextValidator.checkTitleIsEmpty("제목 있음") }
    }

    @Test
    fun `태그에 빈 값이 입력되면 false를 반환한다`() {
        assertFalse { TextValidator.checkNotValidTags("") }
    }

    @Test
    fun `태그별 텍스트가 비어있으면 true를 반환한다`() {
        assertTrue { TextValidator.checkNotValidTags(",태그") }
    }

    @Test
    fun `모든 태그의 텍스트 글자 수가 5자 이하이면 false를 반환한다`() {
        assertFalse { TextValidator.checkNotValidTags("태그, 태그, 태그, 태그, 태그") }
    }
}