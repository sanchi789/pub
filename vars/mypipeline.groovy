def call(String jenkinsSecret, String repoLink, String branchName,String dockerFilePath = 'docker/Dockerfile', String appName){
pipeline {
  agent any

  environment {
  DOCKER_REPO_LINK ="sanchi1111"
  }
  stages {
      stage('Checkout') {
            steps {
                /**sh '''
                git clone https://github_user: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@github.com/Bhavyattn/task.git
                '''*/
                //git branch: 'main', credentialsId: 'q1s', url: 'git@github.com:sanchi789/publicdoc.git'
                //gitClone("q1s","git@github.com:sanchi789/publicdoc.git","main")
               git branch: "${branchName}", credentialsId: "${jenkinsSecret}", url: "${repoLink}" 
            }
   
  }
          //stage('Docker build') {
//               steps {
//                  // dockerBuild("git@github.com:sanchi789/publicdoc.git","latest")
//                 dockerRepoLink = env.DOCKER_REPO_LINK
//                   // handle the error condition here
//                if (!dockerRepoLink || dockerRepoLink.trim().isEmpty()) {
   
//                   error "Invalid DOCKER_REPO_LINK: ${dockerRepoLink}"
//               }

//                 // Define Docker image name and tag
//                def dockerImageName = "${appName}:${env.BUILD_NUMBER}"
//                 // Build Docker image
//                 sh "docker build -t ${dockerRepoLink}/${dockerImageName} ."
//               }
//           }
//             stage('Cleanup Docker Images') {
//             steps {
//                sh 'docker system prune -a -f --filter "until=24h"'
//             }
//         }
}
}
}
