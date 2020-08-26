
//Can make a singaltin because it uses only one type
object Space : BoardItem {
    override val icon: Icon
        get() = Icon.SPACE
    override val walkOn: Boolean
        get() = true
}