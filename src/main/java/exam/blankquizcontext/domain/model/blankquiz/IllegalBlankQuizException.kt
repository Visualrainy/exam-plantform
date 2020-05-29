package exam.blankquizcontext.domain.model.blankquiz

class IllegalBlankQuizException(score: Int) : IllegalArgumentException("Illegal blank quiz with score $score")
