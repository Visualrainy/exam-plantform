package exam.blankquizcontext.domain.model.blankquiz

class NoSuchBlankQuizException(blankQuizId: BlankQuizId) : NoSuchElementException("No such BlankQuiz with id: $blankQuizId")
