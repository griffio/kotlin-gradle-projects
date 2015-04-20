package griffio.anagrams.finder

/**
from collections import Counter
words = ("snow", "nets", "nest", "sent", "whatever", "tens", "bogus", "owns", "sown")
normalized = [tuple(Counter(w)) for w in words]
print(normalized)
d = Counter(normalized)
print(d)
print ([w for w, n in zip(words, normalized) if d[n] > 1])
 */
fun main(args: Array<String>) {

    //"snow", "nets"

    fun given_a_list_of_words_find_all_the_anagrams_in_the_order_in_which_they_appear(words: List<String>) {

        val sortedWords = words map { it.toCharArray() }

        sortedWords.forEach { it.sort() }

        val normalizedWords = sortedWords.map { String(it) }

        val groupedWords = sortedWords groupBy { String(it) }

        println(
            words zip normalizedWords filter { groupedWords.get(it.second)!!.size() > 1 } map { it.first }
        )

    }

    val words = arrayListOf("snow", "nets", "nest", "sent", "whatever", "tens", "bogus", "owns", "sown")

    val groupedWords = words map { it.groupBy { it } }

    println (groupedWords)

    given_a_list_of_words_find_all_the_anagrams_in_the_order_in_which_they_appear(words)
    //[snow, nets, nest, sent, tens, owns, sown]
}