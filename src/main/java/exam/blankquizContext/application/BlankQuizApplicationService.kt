package exam.blankquizContext.application

import exam.blankquizContext.domain.model.blankquiz.BlankQuizRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlankQuizApplicationService @Autowired constructor(private val blankQuizRepository: BlankQuizRepository) {

}
