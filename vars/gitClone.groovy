def call(String jenkinsSecret, String repoLink, String branchName)          
{
   git branch: "${branchName}", credentialsId: "${jenkinsSecret}", url: "${repoLink}"  
   
//     env.DOCKER_IMAGE_TAG = sh(script: "printf \$(git rev-parse --short HEAD)", returnStdout: true )
        
// }
