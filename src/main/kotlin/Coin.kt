/*
    Class to have general properties and behaviours of a coin
 */

interface Coin : BoardItem {
    var point : Int
    override val icon: Icon
        get() = Icon.COIN
    override val walkOn: Boolean
        get() = true

    fun getPoint() {
        point++
    }
}