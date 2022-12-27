object ProjectConfig {
    const val namespaceCommon = "com.niqr.playzone_mobile"
    fun namespace(module: String) = namespaceCommon + "." + module
}