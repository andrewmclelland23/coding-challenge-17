import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PontoonTest {

    @Test
    fun `calculateScores givers correct winner`(){
        val playerPontoon = Hand(arrayOf("KC", "AD"))
        val dealerPontoon = Hand(arrayOf("KC", "AD"))
        val dealer21 = Hand(arrayOf("TC", "AD"))
        val player21 = Hand(arrayOf("TC", "AD"))
        val player20 = Hand(arrayOf("TC", "JD"))
        val dealer20 = Hand(arrayOf("TC", "JD"))
        val player5CardTrick = Hand(arrayOf("3D","2C","4H","AD","5C"))
        val dealer5CardTrick = Hand(arrayOf("3D","2C","4H","AD","5C"))
        val playerBust = Hand(arrayOf("3D","9C","4H","AD","5C"))
        val dealerBust = Hand(arrayOf("3D","9C","4H","AD","5C"))

        assertEquals("Dealer wins with Pontoon!", Pontoon(playerPontoon, dealerPontoon).result)
        assertEquals("Player wins with Pontoon!", Pontoon(playerPontoon, dealer21).result)
        assertEquals("Dealer wins with 5 Card Trick", Pontoon(player5CardTrick, dealer5CardTrick).result)
        assertEquals("Player wins with 5 Card Trick", Pontoon(player5CardTrick, dealer21).result)
        assertEquals("Dealer wins, player is bust with 22", Pontoon(playerBust, dealerBust).result)
        assertEquals("Player wins, dealer is bust with 22", Pontoon(player21, dealerBust).result)
        assertEquals("Dealer wins with 21", Pontoon(player21, dealer21).result)
        assertEquals("Dealer wins with 21", Pontoon(player20, dealer21).result)
        assertEquals("Player wins with 21", Pontoon(player21, dealer20).result)
    }

}