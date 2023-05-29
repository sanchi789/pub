def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String buildUrl)
{
  def color
  def COLOR_MAP = [
      "SUCCESS" = "#36a64f"
      "FAILURE" =  "#ff0000"
      "ABORTED"=  "#f9c300"
      ]
 BUILD_USER = getBuildUser()
         
 //slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
    def message= "*${COLOR_MAP[currentBuild.currentResult]}:* \n *Job_Name:* ${env.JOB_NAME}\n color: *Build_Number:* ${env.BUILD_NUMBER} \n *Build By* ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

  sh  """
    curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${message}\"}' ${buildUrl}
    """
}



