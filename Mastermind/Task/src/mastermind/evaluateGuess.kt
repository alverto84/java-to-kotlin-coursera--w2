package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretList = secret.toList()
    var guessList = guess.toList()
    var rightPosition = 0;
    var wrongPosition = 0;

    for((index, element) in guessList.withIndex()){
        if(element.equals(secretList.get(index))){
            rightPosition++
        }else{
            val mutableSecret = mutableListOf<Char>()
            mutableSecret.addAll(secretList)
            mutableSecret.removeAt(index)
            if(mutableSecret.contains(element)){
                wrongPosition++
            }
        }
    }
    val eval = Evaluation(rightPosition, wrongPosition)
    println(eval)
    return eval
}