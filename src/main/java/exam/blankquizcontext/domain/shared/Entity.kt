package exam.blankquizcontext.domain.shared

interface Entity<T> {
    fun sameAs(other: T): Boolean
}
