package exam.blankquizcontext.userinterface.presentation

import java.time.LocalDateTime

data class BlankQuizResponse(var id: String?,
                             var number: String?,
                             var content: String?,
                             var referenceAnswer: String?,
                             var removed: Boolean,
                             var createTime: LocalDateTime?,
                             var lastUpdateTime: LocalDateTime?,
                             var removeTime: LocalDateTime?) {
    constructor() : this(null, null, null, null,
            false, null, null, null)
}
