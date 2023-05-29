def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String buildUrl)
{
//   def color
//   def COLOR_MAP = [
//         Switch (status) 
//       {
//         case "success":
//             "SUCCESS" = "#36a64f"'
//             break
//         case "failure":
//              "FAILURE" =  "#ff0000"
//             break
//         case "aborted":
//             "ABORTED"="#f9c300"
//             break
//         default:
//             break
//         }
//       ]
 BUILD_USER = getBuildUser()
         
 //slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
    def message= "*${currentBuild.currentResult}:* Job_Name: ${env.JOB_NAME}\n build_Number ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

  sh  """
    curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${message}\"}' ${buildUrl}
    """
}



