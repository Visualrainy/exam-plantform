package exam.blankquizContext.application

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlankQuizApplicationService @Autowired constructor(private val blankQuizRepository: BlankQuizRepository) {

    fun createBlankQuiz(command: BlankQuizCreateCommand): BlankQuiz {
        val blankQuizId = blankQuizRepository.nextBlankQuizId()

        val blankQuiz = BlankQuiz.create(blankQuizId, command.number, command.score, command.description)
        blankQuizRepository.save(blankQuiz)

        return blankQuiz
    }

    fun deleteBlankQuiz(id: BlankQuizId) {
        blankQuizRepository.delete(id)
    }
}
