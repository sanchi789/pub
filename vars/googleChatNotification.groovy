def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}

def call(String webhookUrl) {
    
   BUILD_USER = getBuildUser()
    def message= "*${currentBuild.currentResult}:*\n *AppName:* ${env.app_name}\n*Job_Name:* ${env.JOB_NAME}\n *Build_Number:* ${env.BUILD_NUMBER} \n *Build By* ${BUILD_USER}\n *More info at:* ${env.BUILD_URL}"

    sh """ curl -XPOST -H 'Content-Type: application/json; charset=UTF-8' -d "{"'"text"'": "'"${message}"'"}" "${webhookUrl}"
    """

}




