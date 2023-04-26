def call(String jenkinsSecret, String repoLink, String branchName,String dockerFilePath = 'docker/Dockerfile', String appName, String Docker_repo){
pipeline {
  agent any

//   environment {
//   DOCKER_REPO_LINK ="sanchi1111"
//   }
  stages {
      stage('Checkout') {
            steps {
         
              gitClone("${jenkinsSecret}","${repoLink}","${branchName}")
            }
   
  }
          stage('Docker build') {
              steps {
                
                dockerBuild("${dockerFilePath}","${appName}","${Docker_repo}")
              }
          }
            stage('Cleanup Docker Images') {
            steps {
              cleanupDockerImage()
            }
        }
}
}
}
