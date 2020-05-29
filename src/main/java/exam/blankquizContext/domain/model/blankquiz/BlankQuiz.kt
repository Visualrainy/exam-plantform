package exam.blankquizContext.domain.model.blankquiz

import exam.blankquizContext.domain.shared.Entity

class BlankQuiz(val id: BlankQuizId) : Entity<BlankQuiz> {
    companion object {
        fun create(id: BlankQuizId): BlankQuiz {
            return BlankQuiz(id)
        }
    }

    override fun sameAs(other: BlankQuiz): Boolean {
        return id.sameAs(other.id)
    }
}
