def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call(String buildUrl)
{
  def COLOR_MAP = [
      "SUCCESS": 'good',
      "FAILURE": 'danger',
      "ABORTED": 'warning'
      ]
 BUILD_USER = getBuildUser()
         
    def message= "*${currentBuild.currentResult}*\n *AppName:* ${env.app_name}\n *Job_Name:* ${env.JOB_NAME}\n *Build_Number:* ${env.BUILD_NUMBER} \n *Build By* ${BUILD_USER}\n *More info at:* ${env.BUILD_URL}"
    sh  """
    curl -X POST -H 'Content-type: application/json'  --data '{ \"attachments\": [{ \"color\": \"${COLOR_MAP[currentBuild.currentResult]}\", \"text\": \"${message}\" }] }' ${buildUrl}
    """
}



