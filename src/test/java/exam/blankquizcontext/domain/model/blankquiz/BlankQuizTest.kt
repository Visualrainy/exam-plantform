package exam.blankquizcontext.domain.model.blankquiz

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class BlankQuizTest : StringSpec() {

    private val blankQuiz =
            BlankQuiz.create(BlankQuizId("123"), "456", "content", "referenceAnswer")

    init {
        "should throw exception when create blank quiz with empty answer" {
            val id = BlankQuizId("123")
            val exception = shouldThrow<IllegalBlankQuizAnswerException> {
                BlankQuiz.create(id, "456", "content", "")
            }

            exception.message shouldBe "Illegal blank quiz with empty answer"
        }

        "should throw exception when create blank quiz with empty content" {
            val id = BlankQuizId("123")
            val exception = shouldThrow<IllegalBlankQuizContentException> {
                BlankQuiz.create(id, "456", "", "referenceAnswer")
            }

            exception.message shouldBe "Illegal blank quiz with empty content"
        }

        "should create blank quiz successful" {
            val id = BlankQuizId("123")
            val blankQuiz = BlankQuiz.create(id, "456", "content", "referenceAnswer")

            blankQuiz shouldNotBe null
            blankQuiz.id shouldBe id
        }

        "should revise successful with new content" {
            blankQuiz.revise("new content", "new reference answer")

            blankQuiz.content shouldBe "new content"
            blankQuiz.referenceAnswer shouldBe "new reference answer"
        }

        "should remove successful" {
            blankQuiz.remove()

            blankQuiz.removed shouldBe true
            blankQuiz.removeTime shouldNotBe null
        }
    }
}

