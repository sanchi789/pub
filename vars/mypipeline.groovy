def call(String jenkinsSecret, String repoLink, String branchName,String dockerFilePath = 'docker/Dockerfile', String appName, String dockerRepoLink){
 
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
                
                dockerBuild("${dockerFilePath}","${appName}","${dockerRepoLink}")
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
