def call(String dockerFilePath = 'docker/Dockerfile', String appName) {
    dockerRepoLink = env.DOCKER_REPO_LINK
    try {
    // some code that might throw an exception
} catch (Exception e) {
        error "Invalid input:  ${DOCKER_REPO_LINK} "
}

    // Define Docker image name and tag
    def dockerImageName = "${appName}:${env.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -t ${dockerRepoLink}/${dockerImageName} ."
}
