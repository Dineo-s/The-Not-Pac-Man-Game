/*
    Class to extent superclass Coin and add properties and behaviours of a Silver Coin
 */

object SilverCoin : Coin {
    override var point: Int
        get()  = 2
        set(value) {}
    override val icon: Icon
        get() = super.icon
    override val walkOn: Boolean
        get() = super.walkOn

}