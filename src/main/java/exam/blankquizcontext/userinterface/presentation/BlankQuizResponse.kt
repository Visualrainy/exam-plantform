package exam.blankquizcontext.userinterface.presentation

data class BlankQuizResponse(var id: String?,
                             var number: String?,
                             var content: String?) {
    constructor() : this(null, null, null)
}
