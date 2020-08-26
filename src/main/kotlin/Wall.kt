object Wall : BoardItem {
    override val icon: Icon
        get() = Icon.WALL

    override val walkOn: Boolean
        get() = false
}