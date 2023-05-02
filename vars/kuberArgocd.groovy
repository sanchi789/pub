import com.tothenew.Utilities
def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String gitSecret,String oldTag){
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
    stage('kuber deploy through argod'){
      steps{
       script{
       utilities.kuberneterDeployArgo("${helmRepoLink}","${valuesFilePath}","${newImageTag}","${gitSecret}","${oldTag}")
      }
      }
    }
}
}
}
