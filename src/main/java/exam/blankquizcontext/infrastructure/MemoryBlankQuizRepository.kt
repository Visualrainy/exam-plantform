package exam.blankquizcontext.infrastructure

import exam.blankquizcontext.domain.model.blankquiz.BlankQuiz
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizId
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizRepository
import exam.blankquizcontext.domain.model.blankquiz.NoSuchBlankQuizException
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MemoryBlankQuizRepository : BlankQuizRepository {
    companion object {
        private const val BLANK_QUIZ_ID_PREFIX = "blankquiz-"
    }

    private var blankQuizzes = hashSetOf<BlankQuiz>()

    override fun find(blankQuizId: BlankQuizId): BlankQuiz {
        return blankQuizzes.asSequence()
                .filter { it.id.sameAs(blankQuizId) }
                .firstOrNull() ?: throw NoSuchBlankQuizException(blankQuizId)
    }

    override fun nextBlankQuizId(): BlankQuizId {
        return BlankQuizId(BLANK_QUIZ_ID_PREFIX + UUID.randomUUID().toString())
    }

    override fun save(blankQuiz: BlankQuiz) {
        blankQuizzes.add(blankQuiz)
    }

    override fun getAll(): List<BlankQuiz> {
        return blankQuizzes.toList()
    }

}
