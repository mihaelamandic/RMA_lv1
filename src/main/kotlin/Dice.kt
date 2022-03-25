class Dice {
    private var die: Die = Die()
    private val dice = List(6) {die}

   fun roll() : MutableList<Int> {
       val numbers: MutableList<Int> = mutableListOf()
       dice.forEach { die ->
           if(die.isLocked == false){
               die.roll()
           }
           numbers.add(die.number)
       }
       return numbers
   }

    fun lock(indexOfDie: Int){
        dice[indexOfDie-1].lock()
    }

}
