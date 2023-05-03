import com.tothenew.Utilities
def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String dockerFilePath = 'docker/Dockerfile',String appName,String dockerRepoLink,String oldTag,String repoUrl,String awsRegion){
 utilities = new Utilities()
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
   
   stage('ecr login') {
              steps {
               script{
              utilities.dockerLoginEcr("${repoUrl}","${awsRegion}")
              }
              }
          }
   
   
   stage('Docker push') {
              steps {
               script{
              utilities.dockerPush("${repoUrl}","${appName}")
              }
              }
          }
   
   
   
    stage('kuber deploy through argod'){
      steps{
       script{
       utilities.kuberneterDeployArgo("${helmRepoLink}","${valuesFilePath}","${newImageTag}","${jenkinsSecret}","${oldTag}")
      }
      }
    }
}
}
}
