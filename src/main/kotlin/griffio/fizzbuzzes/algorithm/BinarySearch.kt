package griffio.fizzbuzzes.algorithm

fun main(args: Array<String>) {

    val i = rank(23, arrayOf(5, 10, 15, 20, 23, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70))
    print(i)

}

fun rank(k: Int, a: Array<Int>): Int {
    var l = 0
    var h = a.size - 1
    while (l <= h) {
        val m = l + (h - l) / 2
        val v = a[m]
        if (k < v) {
            h = m - 1
        } else if (k > v) {
            l = m + 1
        } else {
            return m
        }
    }
    return -1
}