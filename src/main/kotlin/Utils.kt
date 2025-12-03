inline fun <T, R> Sequence<T>.foldInPlace(
    initial: R,
    operation: R.(T) -> Unit,
): R = fold(initial) { acc: R, t: T -> acc.apply { operation(t) } }

fun <E> List<E>.splitParts(
    delimiter: E,
): List<List<E>> = asSequence().foldInPlace<E, MutableList<MutableList<E>>>(mutableListOf(mutableListOf())) {
    if (it == delimiter) add(mutableListOf()) else last().add(it)
}

fun <T : Comparable<T>> Iterable<T>.maxIndexed(): IndexedValue<T> = foldIndexed(
    initial = IndexedValue(0, first())
) { idx, acc, it ->
    if (it <= acc.value) acc
    else IndexedValue(idx, it)
}

inline fun <reified T : Enum<T>> T.next(): T = enumValues<T>().run { this[(ordinal + 1) % size] }
