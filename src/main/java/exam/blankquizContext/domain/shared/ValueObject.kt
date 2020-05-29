package exam.blankquizContext.domain.shared

interface ValueObject<T> {
    fun sameAs(other: T): Boolean
}
