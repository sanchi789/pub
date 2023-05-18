def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String channels,String tokens,String isSuccess)
{
  
  def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
    'ABORT': 'warning'
]
  
//    if("${isSuccess}"=="true"){

      BUILD_USER = getBuildUser()
         
 slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
//       }
  
//       else{
//          BUILD_USER = getBuildUser()

//            slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

    
//    }
}
