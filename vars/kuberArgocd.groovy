// import com.tothenew.Utilities
// k
// def call(String jenkinsSecret, String repoLink, String branchName,String helmRepoLink, String valuesFilePath, String newImageTag,String gitSecret){
 
pipeline {
  agent any


  stages {
      stage('Checkout') {
            steps {
         
              gitClone("${jenkinsSecret}","${repoLink}","${branchName}")
            }
   
  }
    stage('kuber deploy through argod'){
      steps{
        kuberneterDeployArgo("${helmRepoLink}", "${valuesFilePath}", "${newImageTag}","${gitSecret}")
      }
    }
}
}
}
