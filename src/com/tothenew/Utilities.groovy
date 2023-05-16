package com.tothenew

//docker image build
 def dockerBuild(String dockerFilePath = 'docker/Dockerfile', String appName,String dockerRepoLink) {
   // dockerRepoLink = env.DOCKER_REPO_LINK
     // handle the error condition here
  if (!dockerRepoLink || dockerRepoLink.trim().isEmpty()) {
   
    error "Invalid DOCKER_REPO_LINK: ${dockerRepoLink}"
}

    // Define Docker image name and tag
    def dockerImageName = "${appName}:${env.DOCKER_IMAGE_TAG}"
    // Build Docker image
    sh "docker build -t ${dockerRepoLink}/${dockerImageName} -f ${dockerFilePath} ."
}

//clean unused images
def cleanupDockerImage() {
    sh 'docker system prune -a -f --filter "until=24h"'
}

//kubernete deploy through argocd
def kuberneterDeployArgo(String helmRepoLink, String valuesFilePath, String newImageTag,String gitSecret,String filePath,String branchName) {
    //gitClone for helm 
    git branch: "${branchName}", credentialsId: "${gitSecret}", url: "${helmRepoLink}"
    oldTag = sh(script: "grep -i \"image:\" ${filePath} | cut -d : -f 3" , returnStdout: true).trim()
    sh "sed -i \'s/${oldTag}/${newImageTag}/g\' ${valuesFilePath}"
    sh "echo ${valuesFilePath}"
    sh '''
    git add .
    git status
    git push --set-upstream origin main
    git commit -m "Publish new version"
    git push
    '''
}

//Docker ecr login
def dockerLoginEcr(String repoUrl , String awsRegion) {  

   sh "aws ecr get-login-password --region ${awsRegion} | sudo docker login --username AWS --password-stdin ${repoUrl}"

}

//kubernete deploy using yaml fil
def kubernetesDeploy(String filePath, String newImageTag) {
      oldTag = sh(script: "grep -i \"image:\" ${filePath} | cut -d : -f 3" , returnStdout: true).trim()
     sh"""
     sed -i \'s/${oldTag}/${newImageTag}/g\' ${filePath}
     kubectl apply -f ${filePath}
    """
}

//Clone repo
def gitClone(String jenkinsSecret, String repoLink, String branchName="main") {
    git branch: "${branchName}", credentialsId: "${jenkinsSecret}", url: "${repoLink}"
    env.DOCKER_IMAGE_TAG = sh(script: "printf \$(git rev-parse --short HEAD)", returnStdout: true)
}

//Push docker repo
def dockerPush(String repoUrl, String imageName) {
  sh "docker push ${repoUrl}/${imageName}:${DOCKER_IMAGE_TAG}"

}
//dockerhub login
def dockerhubLogin(String username,String pass)
{
 sh 'docker login -u "${username}" -p "${pass}" docker.io'
}

