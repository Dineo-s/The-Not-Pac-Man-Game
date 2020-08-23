/*
    Class to have general properties and behaviours of a coin
 */

open class Coin {
    open var point = 0

    open fun getPoint() {
        point++
    }
}