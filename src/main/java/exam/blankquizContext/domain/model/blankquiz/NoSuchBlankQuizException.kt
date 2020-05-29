package exam.blankquizContext.domain.model.blankquiz

class NoSuchBlankQuizException(blankQuizId: BlankQuizId) : NoSuchElementException("No such BlankQuiz with id: $blankQuizId")
