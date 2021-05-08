package com.lmo.ninie.io.constants.text

object MagicStrings {

    const val WHITESPACE = " "
    const val LINE_BREAKER = "\n"
    const val EXCLAMATION = "!"

    // ordering is important here otherwise it would not be a list
    // the repeater service will repeat a word based on the first match, the shorter options should appear later in
    // todo see if this can be improved
    val REPEATER_TRIGGERS = listOf("di", "dis", "dit", "die")

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
        Regex("yo$oneToTenRange"),
        Regex(repeatAllLetters("plop"))
    )

    private fun repeatAllLetters(word: String) =
        word.toList().joinToString(separator = oneToFiveRange, postfix = oneToFiveRange)
}