/*
    Class to extent superclass Coins and add properties and behaviours of a gold coin
 */

class GoldCoin : Coin() {

    override fun getPoint() {
        point += 3
    }

    fun increaseTimer() {
        //Score more time
    }

}