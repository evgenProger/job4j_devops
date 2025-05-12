rootProject.name = "DevOps"
buildCache {
    val cacheUrl = System.getenv("GRADLE_REMOTE_CACHE_URL")
    if (cacheUrl != null) {
        remote<HttpBuildCache> {
            url = uri(cacheUrl)
            isAllowInsecureProtocol = true
            isAllowUntrustedServer = true
            isPush = System.getenv("GRADLE_REMOTE_CACHE_PUSH")?.toBoolean() ?: false
            credentials {
                username = System.getenv("GRADLE_REMOTE_CACHE_USERNAME") ?: ""
                password = System.getenv("GRADLE_REMOTE_CACHE_PASSWORD") ?: ""
            }
        }
    }
}
