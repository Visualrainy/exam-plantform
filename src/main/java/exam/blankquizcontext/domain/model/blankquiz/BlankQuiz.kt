package exam.blankquizcontext.domain.model.blankquiz

import exam.blankquizcontext.domain.shared.Entity

class BlankQuiz private constructor(val id: BlankQuizId,
                                    val number: String,
                                    var content: String) : Entity<BlankQuiz> {
    companion object {
        fun create(id: BlankQuizId, number: String, content: String): BlankQuiz {
            validateBlankQuizContent(content)
            return BlankQuiz(id, number, content)
        }

        private fun validateBlankQuizContent(content: String) {
            if (content.isNullOrBlank()) {
                throw IllegalBlankQuizContentException()
            }
        }
    }

    fun revise(content: String) {
        validateBlankQuizContent(content)
        this.content = content
    }

    override fun sameAs(other: BlankQuiz): Boolean {
        return id.sameAs(other.id)
    }
}
