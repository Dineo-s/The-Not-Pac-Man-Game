/*
    Class to extent superclass Coins and add properties and behaviours of a gold coin
 */

object GoldCoin : Coin {
    override var point: Int
        get() = 5
        set(value) {}

    override val icon: Icon
        get() = Icon.GOLD_COIN
    override val walkOn: Boolean
        get() = super.walkOn

    override fun getPoint() {
        point += 3
    }

    fun increaseTimer() {
        //Score more time
    }

}