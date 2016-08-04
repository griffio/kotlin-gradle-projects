package griffio.things

fun main(args: Array<String>) {
    val sorted = quickSort(arrayListOf(9, 7, 5, 11, 12, 2, 14, 3, 10, 6))
    print(sorted.toList())
}

fun <T : Comparable<T>> quickSort(list: List<T>): Sequence<T> {
    if (list.isEmpty()) return emptySequence()
    val pivot = list[list.size - 1]
    val equal = list.filter { it == pivot }
    val lesser = list.filter { it < pivot }
    val greater = list.filter { it > pivot }
    return quickSort(lesser) + equal + quickSort(greater)
}