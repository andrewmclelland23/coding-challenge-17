class Pontoon(val player: Hand, val dealer: Hand, var result: String = "") {

    init {
        result = when {
            dealer.hasPontoon() -> "Dealer wins with Pontoon!"
            player.hasPontoon() -> "Player wins with Pontoon!"
            dealer.has5CardTrick() -> "Dealer wins with 5 Card Trick"
            player.has5CardTrick() -> "Player wins with 5 Card Trick"
            player.score() > 21 -> "Dealer wins, player is bust with ${player.score()}"
            dealer.score() > 21 -> "Player wins, dealer is bust with ${dealer.score()}"
            player.score() <= dealer.score() -> "Dealer wins with ${dealer.score()}"
            else -> "Player wins with ${player.score()}"
        }
            println(result)
    }
}