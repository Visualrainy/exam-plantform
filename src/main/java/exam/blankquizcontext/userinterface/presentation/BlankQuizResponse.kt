package exam.blankquizcontext.userinterface.presentation

data class BlankQuizResponse(var id: String?,
                             var number: String?,
                             var score: Int?,
                             var description: String?) {
    constructor() : this(null, null, null, null)
}
