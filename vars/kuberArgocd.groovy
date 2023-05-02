import com.tothenew.Utilities
def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String gitSecret,String oldTag){
 
pipeline {
  agent any


  stages {
      stage('Checkout') {
            steps {
         
              Utilities.gitClone("jenkinsSecret","repoLink","branchName")
            }
   
  }
    stage('kuber deploy through argod'){
      steps{
        Utilities.kuberneterDeployArgo("helmRepoLink","valuesFilePath","newImageTag","gitSecret","oldTag")
      }
    }
}
}
}
