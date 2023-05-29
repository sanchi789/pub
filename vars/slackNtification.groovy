def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String buildUrl,String Status)
{
  def color
  def COLOR_MAP = [
//         switch (Status) {
//         case "success":
//             "SUCCESS" = "#36a64f"'
//             break
   Switch (status) {  
    case "success":
        color = "#36a64f"
        statusText = "SUCCESS"
        break
    case "failure":
        color = "#ff0000"
        statusText = "FAILURE"
        break
    case "aborted":
        color = "#f9c300"
        statusText = "ABORTED"
        break
    default:
        color = "#000000"
        statusText = "UNKNOWN STATUS"
        break
}
      ]
//         case "failure":
//             //color = "#ff0000"
//              "FAILURE" =  "#ff0000"
//             break
//         case "aborted":
//            // color = "#f9c300"
//             "ABORTED"="#f9c300"
//             break
//         default:
//             break
 BUILD_USER = getBuildUser()
         
 //slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
  def message= ""color: COLOR_MAP[currentBuild.currentResult]" Job_Name: ${env.JOB_NAME}\n build_Number ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

  sh  """
    curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${messge}\"}' ${buildUrl}
    """
}



