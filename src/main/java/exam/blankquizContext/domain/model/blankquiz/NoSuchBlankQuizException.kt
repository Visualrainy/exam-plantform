package exam.blankquizContext.domain.model.blankquiz

class NoSuchBlankQuizException(blankQuizId: BlankQuizId) : Exception("No such BlankQuiz with id: $blankQuizId")
