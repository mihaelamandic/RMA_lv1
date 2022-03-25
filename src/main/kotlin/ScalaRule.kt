class ScalaRule:IRules {
    override fun isRule(numbers: MutableList<Int>): Boolean {
        numbers.forEachIndexed { index, number ->
            if(index < numbers.size-1) {
                if (number + 1 != numbers[index + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}