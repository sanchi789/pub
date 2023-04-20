def call(String jenkinsSecret, String repoLink, String branchName)          
{
   git branch: "${branchName}", credentialsId: "${jenkinsSecret}", url: "${repoLink}"      
        
}
