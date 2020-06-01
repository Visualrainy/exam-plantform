package exam.blankquizcontext.application

import exam.blankquizcontext.domain.model.blankquiz.BlankQuiz
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizId
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizRepository
import exam.blankquizcontext.userinterface.presentation.BlankQuizCreateCommand
import exam.blankquizcontext.userinterface.presentation.BlankQuizUpdateCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlankQuizApplicationService @Autowired constructor(private val blankQuizRepository: BlankQuizRepository) {

    fun createBlankQuiz(command: BlankQuizCreateCommand): BlankQuiz {
        val blankQuizId = blankQuizRepository.nextBlankQuizId()

        val blankQuiz = BlankQuiz.create(blankQuizId, command.number, command.content, command.referenceAnswer)
        blankQuizRepository.save(blankQuiz)

        return blankQuiz
    }

    fun reviseBlankQuiz(id: BlankQuizId, command: BlankQuizUpdateCommand) {
        val blankQuiz = blankQuizRepository.find(id)

        blankQuiz.revise(command.content, command.referenceAnswer)
        blankQuizRepository.save(blankQuiz)
    }

    fun removeBlankQuiz(id: BlankQuizId) {
        val blankQuiz = blankQuizRepository.find(id)

        blankQuiz.remove()
        blankQuizRepository.save(blankQuiz)
    }

    fun getAll(): List<BlankQuiz> {
        return blankQuizRepository.getAll()
    }
}
