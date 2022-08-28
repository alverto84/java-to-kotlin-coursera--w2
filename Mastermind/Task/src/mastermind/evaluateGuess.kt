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
            if(containsInSubSecret(element, index, secretList)){
                wrongPosition++
            }
        }
    }
    val eval = Evaluation(rightPosition, wrongPosition)
    println(eval)
    return eval
}
 fun containsInSubSecret(element : Char, index : Int, secretList: List<Char>): Boolean {
     val mutableSecret = mutableListOf<Char>()
     mutableSecret.addAll(secretList)
     mutableSecret.removeAt(index)
    return mutableSecret.contains(element)
}