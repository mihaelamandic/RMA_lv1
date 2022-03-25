import kotlin.system.exitProcess

class Yahtzee {
    private var numbers: MutableList<Int> = mutableListOf()
    private var points: Int = 0
    private var dice: Dice = Dice()
    private var fullRule: IRules = FullRule()
    private var scalaRule: IRules = ScalaRule()
    private var yahtzeeRule: IRules = YahtzeeRule()



    fun play(){
        for(i in 0..2){
            println("Round ${i+1} begins!")
            startRound()
            if(i<2) {
                println("Write 'next' when you are ready for next round.")
                println("Write 1 .. 6 to lock the die")
                getUserInput()
            }
        }
        println("Game over.")
    }
    private fun startRound() {
        numbers = dice.roll()

        println(numbers)

        val isYahtzee: Boolean = yahtzeeRule.isRule(numbers)
        val isScala: Boolean = scalaRule.isRule(numbers)
        val isFull: Boolean = fullRule.isRule(numbers)
        var points = 0
        if(isYahtzee){
            points += getSumOfDiceNumbers() + 50
            println("You got Yahtzee")
        } else if(isScala) {
            points += 30
            println("You got Scala")
        }
        else if(isFull){
            points += getSumOfDiceNumbers() + 30
            println("You got Full")
        } else {
            points = 0
        }

        println("Points for this round are: $points")
        numbers.clear()
    }

    private fun getSumOfDiceNumbers(): Int{
        var points = 0
        numbers.forEach { number ->
            points += number
        }
        return points
    }

    private fun getUserInput(){
        when (val userInput: String = readLine()!!) {
            "1", "2", "3", "4", "5", "6" -> {
                val lockDie = Integer.parseInt(userInput)
                println("Locking die at index $lockDie")
                dice.lock(lockDie)
            }
            "next" -> {
                return
            }

            else -> {
                println("Incorrect input... Try again")
                getUserInput()
            }
        }
    }
}