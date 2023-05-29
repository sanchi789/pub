def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}

def call(String webhookUrl) {
   BUILD_USER = getBuildUser()
 def message= "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
    sh "curl -X POST -H 'Content-Type: application/json' -d '{\"text\": \"${message}\"}' ${webhookUrl}"

}




