package exam.blankquizcontext.domain.model.blankquiz

import exam.blankquizcontext.domain.shared.Entity

class BlankQuiz private constructor(val id: BlankQuizId,
                                    val number: String,
                                    var score: Int,
                                    var description: String) : Entity<BlankQuiz> {
    companion object {
        private const val MAX_SCORE = 100
        private const val MIN_SCORE = 1

        fun create(id: BlankQuizId, number: String, score: Int, description: String): BlankQuiz {
            validateBlankQuizScore(score)
            return BlankQuiz(id, number, score, description)
        }

        private fun validateBlankQuizScore(score: Int) {
            if (score > MAX_SCORE || score < MIN_SCORE) {
                throw IllegalBlankQuizException(score)
            }
        }
    }

    fun revise(score: Int, description: String) {
        validateBlankQuizScore(score)
        this.score = score
        this.description = description
    }

    override fun sameAs(other: BlankQuiz): Boolean {
        return id.sameAs(other.id)
    }
}
