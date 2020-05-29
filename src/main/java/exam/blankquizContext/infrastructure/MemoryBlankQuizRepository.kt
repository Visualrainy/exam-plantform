package exam.blankquizContext.infrastructure

import exam.blankquizContext.domain.model.blankquiz.BlankQuiz
import exam.blankquizContext.domain.model.blankquiz.BlankQuizId
import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository
import exam.blankquizContext.domain.model.blankquiz.NoSuchBlankQuizException
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MemoryBlankQuizRepository : BlankQuizRepository {
    private var blankQuizzes: List<BlankQuiz> = LinkedList()

    override fun find(blankQuizId: BlankQuizId): BlankQuiz {
        return blankQuizzes.asSequence()
                .filter { it.id.sameAs(blankQuizId) }
                .firstOrNull() ?: throw NoSuchBlankQuizException(blankQuizId)
    }

    override fun save() {

    }

}
