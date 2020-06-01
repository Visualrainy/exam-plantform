package exam.blankquizcontext.domain.model.blankquiz

import exam.blankquizcontext.domain.shared.Entity
import java.time.LocalDateTime

class BlankQuiz private constructor(val id: BlankQuizId,
                                    val number: String,
                                    var content: String,
                                    val referenceAnswer: String,
                                    val createTime: LocalDateTime,
                                    var lastUpdateTime: LocalDateTime,
                                    var removeTime: LocalDateTime? = null,
                                    var removed: Boolean = false) : Entity<BlankQuiz> {
    companion object {
        fun create(id: BlankQuizId, number: String, content: String, referenceAnswer: String): BlankQuiz {
            validateBlankQuiz(content, referenceAnswer)
            return BlankQuiz(id, number, content, referenceAnswer, LocalDateTime.now(), LocalDateTime.now())
        }

        private fun validateBlankQuiz(content: String, referenceAnswer: String) {
            if (content.isBlank()) {
                throw IllegalBlankQuizContentException()
            }

            if (referenceAnswer.isBlank()) {
                throw IllegalBlankQuizAnswerException();
            }
        }
    }

    fun revise(content: String, referenceAnswer: String) {
        validateBlankQuiz(content, referenceAnswer)
        this.content = content
        lastUpdateTime = LocalDateTime.now()
    }

    fun remove() {
        removed = true
        removeTime = LocalDateTime.now()
    }

    override fun sameAs(other: BlankQuiz): Boolean {
        return id.sameAs(other.id)
    }
}
