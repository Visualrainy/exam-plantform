package exam.blankquizcontext.application

import exam.blankquizcontext.userinterface.presentation.BlankQuizCreateCommand
import exam.blankquizcontext.userinterface.presentation.BlankQuizUpdateCommand
import exam.blankquizcontext.domain.model.blankquiz.BlankQuiz
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizId
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlankQuizApplicationService @Autowired constructor(private val blankQuizRepository: BlankQuizRepository) {

    fun createBlankQuiz(command: BlankQuizCreateCommand): BlankQuiz {
        val blankQuizId = blankQuizRepository.nextBlankQuizId()

        val blankQuiz = BlankQuiz.create(blankQuizId, command.number, command.content)
        blankQuizRepository.save(blankQuiz)

        return blankQuiz
    }

    fun reviseBlankQuiz(id: BlankQuizId, command: BlankQuizUpdateCommand) {
        val blankQuiz = blankQuizRepository.find(id)

        blankQuiz.revise(command.content)
        blankQuizRepository.save(blankQuiz)
    }

    fun removeBlankQuiz(id: BlankQuizId) {
        blankQuizRepository.delete(id)
    }

    fun getAll(): List<BlankQuiz> {
        return blankQuizRepository.getAll()
    }
}
