package exam.blankquizContext.domain.shared

interface Entity<T> {
    fun sameAs(other: T): Boolean
}
