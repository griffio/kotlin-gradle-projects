package griffio.spelling
//http://norvig.com/spell-correct.html
fun main(args: Array<String>) {
    val word = "comiler"
    var alphabet = "abcdefghijklmnopqrstuvwxyz"
    //splits     = [(word[:i], word[i:]) for i in range(len(word) + 1)]
    //deletes    = [a + b[1:] for a, b in splits if b]
    //transposes = [a + b[1] + b[0] + b[2:] for a, b in splits if len(b)>1]
    //replaces   = [a + c + b[1:] for a, b in splits for c in alphabet if b]
    //inserts    = [a + c + b     for a, b in splits for c in alphabet]
    var splits = IntRange(0, word.length()).map { it -> Pair(word.take(it), word.drop(it)) }
    var deletes = splits filter { it -> it.second.isNotEmpty() } map { it -> it.first.concat(it.second.substring(1)) }
    var transposes = splits filter { it -> it.second.length() > 1 } map { it -> it.first + it.second.get(1) + it.second.get(0) + it.second.substring(2) }
    var replaces = alphabet.flatMap { alpha -> splits filter { it.second.isNotEmpty() } map { it -> it.first + alpha + it.second.substring(1) } }
    var inserts = alphabet.flatMap { alpha -> splits map { it -> it.first + alpha + it.second } }
}
