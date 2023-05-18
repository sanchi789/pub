def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String channels,String tokens)
{
  
  def COLOR_MAP = [
    'ALWAYS': 'info',
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
    'ABORT': 'warning'
]
 BUILD_USER = getBuildUser()
         
 slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

}
