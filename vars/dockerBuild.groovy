def dockerBuild(String dockerFilePath = 'docker/Dockerfile', String appName = env.JOB_NAME, String dockerRepoLink = '') {
    // Define Docker image name and tag
    def dockerImageName = "${appName}:${env.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -t ${dockerImageName} -f ${dockerFilePath} ."
    // Tag Docker image with repository link
    if (dockerRepoLink) {
        sh "docker tag ${dockerImageName} ${dockerRepoLink}/${dockerImageName}"
    }
}
