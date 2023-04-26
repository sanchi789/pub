def call(String dockerFilePath = 'docker/Dockerfile', String appName,String dockerRepoLink) {
   // dockerRepoLink = env.DOCKER_REPO_LINK
     // handle the error condition here
  if (!dockerRepoLink || dockerRepoLink.trim().isEmpty()) {
   
    error "Invalid DOCKER_REPO_LINK: ${dockerRepoLink}"
}

    // Define Docker image name and tag
    def dockerImageName = "${appName}:${env.BUILD_NUMBER}"
    // Build Docker image
    sh "docker build -t ${dockerRepoLink}/${dockerImageName} ."
}
