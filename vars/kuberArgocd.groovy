import com.tothenew.Utilities
def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String dockerFilePath = 'docker/Dockerfile',String dockerRepoLink,String oldTag,String username,String pass){
 utilities = new Utilities()
 def appName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('.'))

pipeline {
  agent any
  

  stages {
      stage('Checkout') {
            steps {
             script{
             utilities.gitClone("${jenkinsSecret}","${repoLink}","${branchName}")
            }
            }
   
  }
   
   stage('Docker build') {
              steps {
               script{
                 utilities.dockerBuild("${dockerFilePath}","${appName}","${dockerRepoLink}")
              }
              }
          }
   
   stage('docker login') {
              steps {
               script{
              utilities.dockerhubLogin("${username}","${pass}")
              }
              }
          }
   
   
   stage('Docker push') {
              steps {
               script{
              utilities.dockerPush("${dockerRepoLink}","${appName}")
              }
              }
          }
   
   
   
    stage('kuber deploy through argod'){
      steps{
       script{
       utilities.kuberneterDeployArgo("${helmRepoLink}","${valuesFilePath}","${newImageTag}","${jenkinsSecret}","${oldTag}","${branchName}")
      }
      }
    }
}
}
}
