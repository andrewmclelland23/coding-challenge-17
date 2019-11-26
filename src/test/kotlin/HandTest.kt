import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HandTest {

    @Test
    fun `should create player and dealer`(){
        val player = Hand(arrayOf("QH", "AC"))
        assertEquals(2, player.hand.size)
    }

    @Test
    fun `should throw error for invalid cards`(){
        val exception = assertThrows(IllegalArgumentException::class.java) { Hand(arrayOf("HC", "AC")) }
        assertEquals("'HC' is not a valid card selection", exception.message)
    }

    @Test
    fun `hasPontoon returns true for face card and Ace`(){
        val player = Hand(arrayOf("AC", "KC"))
        assertEquals(true, player.hasPontoon())
    }

    @Test
    fun `score returns sum of values`(){
        val player = Hand(arrayOf("AC", "KC"))
        assertEquals(21, player.score())
    }

    @Test
    fun `score switches an Ace value to 1 if bust`(){
        val player = Hand(arrayOf("AC", "KC", "2D"))
        assertEquals(13, player.score())
    }

    @Test
    fun `score switches minimum number of aces to 1 to achieve a score under 22`(){
        val player1 = Hand(arrayOf("AC", "AH", "AD"))
        val player2 = Hand(arrayOf("JC", "AH", "AD", "9D"))
        val player3 = Hand(arrayOf("4C", "AH", "AD", "5D"))
        assertEquals(13, player1.score())
        assertEquals(21, player2.score())
        assertEquals(21, player3.score())
    }

    @Test
    fun `hasPontoon returns false when not pontoon`(){
        val player1 = Hand(arrayOf("AC", "KC", "3C"))
        val player2 = Hand(arrayOf("4C", "KC"))
        assertEquals(false, player1.hasPontoon())
        assertEquals(false, player2.hasPontoon())
    }

    @Test
    fun `has5CardTrick returns true when 5 cards with score smaller than 22`(){
        val player = Hand(arrayOf("3D","2C","4H","AD","5C"))
        assertEquals(true, player.has5CardTrick())
    }

    @Test
    fun `has5CardTrick returns false when less than 5 cards`(){
        val player = Hand(arrayOf("3D","2C","4H","AD"))
        assertEquals(false, player.has5CardTrick())
    }

    @Test
    fun `has5CardTrick returns false 5 cards with score larger than 21`(){
        val player = Hand(arrayOf("3D","2C","4H","KD","3C"))
        assertEquals(false, player.has5CardTrick())
    }
}