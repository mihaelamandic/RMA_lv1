class YahtzeeRule:IRules {
    override fun isRule(numbers: MutableList<Int>): Boolean {
        numbers.forEach { number ->
            if(number != numbers[0]){
                return false;
            }
        }
        return true;
    }
}