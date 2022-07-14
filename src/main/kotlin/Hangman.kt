import java.util.*
import kotlin.random.Random

val wordlist = listOf("scarecrow", "grapes", "pencil", "show", "templar", "assassin", "power", "leader", "king", "queen", "jack", "cockroach")
var word = ""
var guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0
var exit = false
var gameOver = false

fun main(args: Array<String>){
    setupGame()
}

fun setupGame(){
    while(!exit){
        println("\n   _   _   _   _   _   _   _  \n" +
                "  / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                " ( H | a | n | g | m | a | n )\n" +
                "  \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ")
        println("\n1. Start game\n2. Exit\n")

        while(true){
            val choice = readLine()?:"1"
            if(choice == "1"){
                break
            }
            else if(choice == "2") {
                exit = true
                break
            }
            else if(choice != "1") {
                print("Invalid choice!")
                continue
            }
        }

        if(exit)
            break;

        val wordIndex = Random.nextInt(wordlist.size)
        word = wordlist[wordIndex].uppercase(Locale.getDefault())

        for(i in word.indices)
            guesses.add('_')

        do{
            printGameStatus()
            print("Please enter a letter: ")
            val input = readLine()?:""

            if(input.isEmpty()){
                println("It should not be empty!")
            }
            else{
                val letter = input[0].uppercaseChar()
                if(word.contains(letter)){
                    for (i in word.indices){
                        if(word[i] == letter){
                            guesses[i] = letter
                        }
                    }
                    if(!guesses.contains('_'))
                        gameOver = true
                }
                else{
                    println("Sorry, you made a wrong guess")
                    remainingGuesses--
                    mistakes++
                    if(mistakes == 6)
                        gameOver = true
                }
            }
        }while (!gameOver)

        if(mistakes == 6) {
            printGameStatus()
            println("Sorry you lost the game, the word was $word. You were HANGED!")
        }
        else{
            println("Congratulations, you won. You have been released from execution!")
            println("The word was $word")
        }

        resetProps()

        println("Do you want to play again?(y/n)")
        while(true){
            val chply = readLine()?:""
            if(chply.isEmpty() || chply in listOf("Y", "y")){
                break
            }
            else if(chply in listOf("N", "n")) {
                exit = true
                break
            }
            else
                println("Invalid choice. Please enter either y/n")
        }
    }
}

fun resetProps(){
    word = ""
    guesses = arrayListOf<Char>()
    remainingGuesses = 6
    mistakes = 0
    gameOver = false
}

fun printGameStatus(){
    when(mistakes){
        0 -> print0mistakes()
        1 -> print1mistake()
        2 -> print2mistakes()
        3 -> print3mistakes()
        4 -> print4mistakes()
        5 -> print5mistakes()
        6 -> print6mistakes()
    }

    print("Word: ")
    for(element in guesses)
        print("$element ")
    println("\nYou have $remainingGuesses guess(es) left")
}

fun print0mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1mistake(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6mistakes(){
    println("  |------|-")
    println("  |      | ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}
