package exam.blankquizcontext.domain.model.blankquiz

interface BlankQuizRepository {
    fun find(blankQuizId: BlankQuizId): BlankQuiz
    fun save(blankQuiz: BlankQuiz)
    fun nextBlankQuizId(): BlankQuizId
    fun delete(blankQuizId: BlankQuizId)
    fun getAll(): List<BlankQuiz>
}
