def call(String dockerFilePath = 'docker/Dockerfile', String appName) {
    dockerRepoLink = env.DOCKER_REPO_LINK
    // Define Docker image name and tag
    def dockerImageName = "${appName}:${env.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -t ${dockerImageName}:${BUILD_NUMBER} ."
    // Tag Docker image with repository link
    if (dockerRepoLink) {
        sh "docker tag ${dockerImageName} ${dockerRepoLink}/${dockerImageName}"
    }
}
