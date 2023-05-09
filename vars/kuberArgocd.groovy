import com.tothenew.Utilities
def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String dockerFilePath = 'docker/Dockerfile',String dockerRepoUrl,String oldTag,String awsRegion,String appName){
 utilities = new Utilities()
// def appName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('.'))

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
   
   stage('ECR login') {
              steps {
               script{
              utilities.dockerLoginEcr("${dockerRepoUrl}","${awsRegion}")
              }
              }
          }
   
   
   stage('Docker ECR push'){
          steps {
               script{
                   utilities.dockerPush("${dockerRepoUrl}","${appName}")
               }
           }
       }

    stage('kuber deploy through argod'){
      steps {
       script{
       utilities.kuberneterDeployArgo("${helmRepoLink}","${valuesFilePath}","${newImageTag}","${jenkinsSecret}","${oldTag}","${branchName}")
      }
      }
    }
}
}
}
