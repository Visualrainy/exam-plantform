package exam.blankquizContext.domain.model.blankquiz

import exam.blankquizContext.domain.shared.Entity

class BlankQuiz(val id: BlankQuizId): Entity<BlankQuiz> {
    override fun sameAs(other: BlankQuiz): Boolean {
        return true
    }

}
