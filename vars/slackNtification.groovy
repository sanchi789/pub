def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String buildUrl,String Status)
{
  def color
  def COLOR_MAP = [
      if (status=='SUCCESS') {
         SUCCESS: "#36a64f", 
          }
      else if (status=='ABORTED') {
         ABORTED: "#f9c300",
          }
      else
      {
         FAILURE: "#ff0000"
      }
]
        ]
 BUILD_USER = getBuildUser()
         
 //slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
  def message= ""color: COLOR_MAP[currentBuild.currentResult]" Job_Name: ${env.JOB_NAME}\n build_Number ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"

  sh  """
    curl -X POST -H 'Content-type: application/json' --data '{\"text\":\"${messge}\"}' ${buildUrl}
    """
}



