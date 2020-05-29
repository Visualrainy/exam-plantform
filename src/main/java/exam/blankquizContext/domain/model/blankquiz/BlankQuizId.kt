package exam.blankquizContext.domain.model.blankquiz

import exam.blankquizContext.domain.shared.ValueObject


class BlankQuizId(private val id: String) : ValueObject<BlankQuizId> {
    override fun sameAs(other: BlankQuizId): Boolean {
        return this == other
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            !is BlankQuizId -> false
            else -> this === other || this.id == other.id
        }
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
