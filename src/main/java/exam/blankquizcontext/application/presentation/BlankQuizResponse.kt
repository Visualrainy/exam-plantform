package exam.blankquizcontext.application.presentation

data class BlankQuizResponse(var id: String?,
                             var number: String?,
                             var score: Int?,
                             var description: String?) {
    constructor() : this(null, null, null, null)
}
