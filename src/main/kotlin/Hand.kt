class Hand(hand: Array<String>) {

    val hand : MutableList<Card> = mutableListOf()

    init {
        hand.forEach {
            val card = Card.getCard(it[0].toString(), it[1].toString())
                ?: throw(IllegalArgumentException("'$it' is not a valid card selection"))
            this.hand.add(card)
        }
        this.hand.sortBy { it.value }
    }

    fun hasPontoon() : Boolean {
        return hand.size == 2 && hand[0].face && hand[1].rank == "A"
    }

    fun score() : Int {
        var score = hand.sumBy { it.value }
        val aceCount = hand.filter {it.rank == "A"}.size
        repeat(aceCount) { if(score > 21) { score -= 10 } }
        return score
    }

    fun has5CardTrick() : Boolean {
        return hand.size == 5 && score() <= 21
    }
}