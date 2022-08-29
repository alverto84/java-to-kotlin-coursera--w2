package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var secretList = secret.toList()
    var guessList = guess.toList()
    var rightPosition = 0;
    var wrongPosition = 0;
    var subSecret = secret.toMutableList();

    for((index, element) in guessList.withIndex()){
        if(element.equals(secretList.get(index))){
            rightPosition++
        }else{
            subSecret = subSecret.subList(index, secretList.size-1)
            if(secretList.contains(element)){
                wrongPosition++
            }
        }
    }
    val eval = Evaluation(rightPosition, wrongPosition)
    println(eval)
    return eval
}