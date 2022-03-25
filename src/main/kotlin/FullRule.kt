class FullRule:IRules {
    override fun isRule(numbers: MutableList<Int>): Boolean {
        if ((((numbers[0] == numbers[1]) && (numbers[1] == numbers[2]))
                    && (numbers[3] == numbers[4]) &&
                    (numbers[2] != numbers[3]))
                    || ((numbers[0] == numbers[1]) &&
                    ((numbers[2] == numbers[3]) && (numbers[3] == numbers[4]))
                    && (numbers[1] != numbers[2])))
        {
            return true
        }

        return false
    }
}