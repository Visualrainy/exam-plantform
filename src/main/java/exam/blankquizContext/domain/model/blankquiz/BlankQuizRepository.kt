package exam.blankquizContext.domain.model.blankquiz

interface BlankQuizRepository {
    fun find(blankQuizId: BlankQuizId): BlankQuiz
    fun save()
}
