def call(String channels,String tokens,String messages,String isSuccess)
{
  
  def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
]
  
  
  def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
  
   if("${isSuccess}"=="true"){
//       def successMessage = "*Job Succeeded* :white_check_mark:\n\n"
//       def formattedMessag = successMessage + "> ${messages}"
      BUILD_USER = getBuildUser()
           //    slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessag}")
 slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
      }
  
      else{
         BUILD_USER = getBuildUser()
//          def failureMessage = ":x: *Job Failed* :x:\n\n"
//          def formattedMessage = failureMessage + "> ${messages}"
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")
    
   }
}
