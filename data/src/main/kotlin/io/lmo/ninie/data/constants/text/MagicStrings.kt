package io.lmo.ninie.data.constants.text

object MagicStrings {

    const val WHITESPACE = ' '
    const val LINE_BREAKER = "\n"
    const val EXCLAMATION = "!"

    private const val oneToFiveRange = "{1,5}"
    private const val oneToTenRange = "{1,10}"

    val GREETER_REGEXES = listOf(
        Regex(repeatAllLetters("he") + "l{2,5}" + "o$oneToFiveRange"),
        Regex(repeatAllLetters("salut")),
        Regex(repeatAllLetters("coucou")),
        Regex(repeatAllLetters("bonjour")),
        Regex(repeatAllLetters("bijour")),
        Regex(repeatAllLetters("bonsoir")),
        Regex(repeatAllLetters("bonswar")),
        Regex(repeatAllLetters("bonsoer")),
        Regex(repeatAllLetters("hey")),
        Regex("yo$oneToTenRange"),
        Regex(repeatAllLetters("plop"))
    )

    private fun repeatAllLetters(word: String) =
        word.toList().joinToString(separator = oneToFiveRange, postfix = oneToFiveRange)
}
