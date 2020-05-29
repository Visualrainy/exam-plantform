package exam.blankquizcontext.userinterface

import exam.blankquizcontext.application.BlankQuizApplicationService
import exam.blankquizcontext.application.presentation.BlankQuizCreateCommand
import exam.blankquizcontext.application.presentation.BlankQuizResponse
import exam.blankquizcontext.application.presentation.BlankQuizUpdateCommand
import exam.blankquizcontext.common.mapper.ModelMapperFactory
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/blank-quizzes")
class BlankQuizController @Autowired constructor(val blankQuizApplicationService: BlankQuizApplicationService) {

    @GetMapping
    fun getAll(): List<BlankQuizResponse> {
        return blankQuizApplicationService.getAll().asSequence()
                .map { ModelMapperFactory.mapper.map(it, BlankQuizResponse::class.java) }
                .toList()
    }

    @PostMapping
    fun createBlankQuiz(@RequestBody blankQuizCreateCommand: BlankQuizCreateCommand): BlankQuizResponse? {
        val blankQuiz = blankQuizApplicationService.createBlankQuiz(blankQuizCreateCommand)

        return ModelMapperFactory.mapper.map(blankQuiz, BlankQuizResponse::class.java)
    }

    @PutMapping("/{id}")
    fun updateBlankQuiz(@PathVariable id: BlankQuizId, @RequestBody blankQuizUpdateCommand: BlankQuizUpdateCommand) {
        blankQuizApplicationService.updateBlankQuiz(id, blankQuizUpdateCommand)
    }

    @DeleteMapping("/{id}")
    fun deleteBlankQuiz(@PathVariable id: BlankQuizId) {
        blankQuizApplicationService.deleteBlankQuiz(id)
    }

}
