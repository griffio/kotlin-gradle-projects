package griffio.spelling

import com.google.common.collect.HashMultiset
import java.net.URL

class Correction(var resource : String) {

    var alphabet = "abcdefghijklmnopqrstuvwxyz"

    var wordsN = train(words())

    infix fun List<String>.or(a: List<String>): List<String> {
        return if (this.isNotEmpty()) this else a
    }

    fun loadResource(): URL {
        return this.javaClass.getResource(resource)
    }

    fun words(): String {
        return loadResource().readText(charset = Charsets.ISO_8859_1)
    }

    fun train(words: String): HashMultiset<String> {
        //val alphas = Splitter.on(CharMatcher.WHITESPACE).trimResults(CharMatcher.inRange('a', 'z').negate())
        val trainingSet = words.split(" ").filter { it.isNotEmpty() }.map { it.filter { it in 'a'..'z' } }
        return HashMultiset.create(trainingSet)
    }

    //    //splits     = [(word[:i], word[i:]) for i in range(len(word) + 1)]
    //    //deletes    = [a + b[1:] for a, b in splits if b]
    //    //transposes = [a + b[1] + b[0] + b[2:] for a, b in splits if len(b)>1]
    //    //replaces   = [a + c + b[1:] for a, b in splits for c in alphabet if b]
    //    //inserts    = [a + c + b     for a, b in splits for c in alphabet]

    fun edits1(word: String): Set<String> {
        var splits = IntRange(0, word.length).map { it -> Pair(word.take(it), word.drop(it)) }
        var edits1 = hashSetOf<String>()
        splits.filter { it -> it.second.isNotEmpty() }.mapTo(edits1) { it -> it.first.concat(it.second.substring(1)) }
        splits.filter { it -> it.second.length > 1 }.mapTo(edits1) { it -> it.first + it.second[1] + it.second[0] + it.second.substring(2) }
        alphabet.flatMapTo(edits1) { alpha -> splits.filter { it.second.isNotEmpty() }.map { it -> it.first + alpha + it.second.substring(1) } }
        alphabet.flatMapTo(edits1) { alpha -> splits.map { it -> it.first + alpha + it.second } }
        return edits1
    }

    //set(e2 for e1 in edits1(word) for e2 in edits1(e1) if e2 in NWORDS)
    fun known_edits2(word: String): List<String> {
        return edits1(word).flatMapTo(arrayListOf<String>()) { e1 -> edits1(e1).filter { e2 -> wordsN.contains(e2) }.map { e2 -> e2 } }
    }

    //set(w for w in words if w in NWORDS)
    fun known(words: List<String>): List<String> {
        return words.filter { word -> wordsN.contains(word) }
    }

    //candidates = known([word]) or known(edits1(word)) or known_edits2(word) or [word]
    fun correct(word: String): String {
        var candidates = listOf(word)
        candidates = ((known(candidates) or known(edits1(word).toList())) or known_edits2(word)) or candidates
        return candidates.maxBy { wordsN.count(it) }.orEmpty()
    }

}

// http://norvig.com/spell-correct.html
fun main(args: Array<String>) {
    println(Correction("/big.txt").correct("transparen")) //transparent
}