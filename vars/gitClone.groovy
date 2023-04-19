def call(String jenkinsSecret, String repoLink, String branchName)          
{
    withCredentials([usernamePassword(credentialsId: "${jenkinsSecret}")]) {         
      sh "git clone -b ${branchName} ${repoLink}"   
}
        
        
          }
