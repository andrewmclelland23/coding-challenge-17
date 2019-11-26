enum class Card(val value: Int, val rank: String, val suit: String, val face: Boolean = false) {

    HTWO(2, "2", "H"),
    HTHREE(3, "3", "H"),
    HFOUR(4, "4", "H"),
    HFIVE(5, "5", "H"),
    HSIX(6, "6", "H"),
    HSEVEN(7, "7", "H"),
    HEIGHT(8, "8", "H"),
    HNINE(9, "9", "H"),
    HTEN(10, "T", "H"),
    HJACK(10, "J", "H", true),
    HQUEEN(10, "Q", "H", true),
    HKING(10, "K", "H", true),
    HACE(11, "A", "H"),

    DTWO(2, "2", "D"),
    DTHREE(3, "3", "D"),
    DFOUR(4, "4", "D"),
    DFIVE(5, "5", "D"),
    DSIX(6, "6", "D"),
    DSEVEN(7, "7", "D"),
    DEIGHT(8, "8", "D"),
    DNINE(9, "9", "D"),
    DTEN(10, "T", "D"),
    DJACK(10, "J", "D", true),
    DQUEEN(10, "Q", "D", true),
    DKING(10, "K", "D", true),
    DACE(11, "A", "D"),

    STWO(2, "2", "S"),
    STHREE(3, "3", "S"),
    SFOUR(4, "4", "S"),
    SFIVE(5, "5", "S"),
    SSIX(6, "6", "S"),
    SSEVEN(7, "7", "S"),
    SEIGHT(8, "8", "S"),
    SNINE(9, "9", "S"),
    STEN(10, "T", "S"),
    SJACK(10, "J", "S", true),
    SQUEEN(10, "Q", "S", true),
    SKING(10, "K", "S", true),
    SACE(11, "A", "S"),

    CTWO(2, "2", "C"),
    CTHREE(3, "3", "C"),
    CFOUR(4, "4", "C"),
    CFIVE(5, "5", "C"),
    CSIX(6, "6", "C"),
    CSEVEN(7, "7", "C"),
    CEIGHT(8, "8", "C"),
    CNINE(9, "9", "C"),
    CTEN(10, "T", "C"),
    CJACK(10, "J", "C", true),
    CQUEEN(10, "Q", "C", true),
    CKING(10, "K", "C", true),
    CACE(11, "A", "C");

    companion object {
        fun getCard(rank: String, suit: String) : Card? {
            return Card.values().find { it.rank == rank && it.suit == suit}
        }
    }
}