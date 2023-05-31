def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}

def call(String webhookUrl) {
   BUILD_USER = getBuildUser()
 //def message= "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
     def message= "*${currentBuild.currentResult}:*\n *Job_Name:* ${env.JOB_NAME}\n *Build_Number:* ${env.BUILD_NUMBER} \n *Build By* ${BUILD_USER}\n *More info at:* ${env.BUILD_URL}"
    sh """
    curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${message}\"}' ${webhookUrl}
    """

    
//   sh  """
//     curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${message}\"}' ${buildUrl}
//     """
}




