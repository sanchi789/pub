def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}
  
def call()
{
  
  def COLOR_MAP = [
    'SUCCESS': 'good', 
    'FAILURE': 'danger',
    'ABORT': 'warning'
]
 BUILD_USER = getBuildUser()
         
 //slackSend channel: "${channels}", color: COLOR_MAP[currentBuild.currentResult], token: "${tokens}", message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
//def message= "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
  //  curl -X POST -H 'Content-type: application/json' --data '{"text":"${messge}"}' https://hooks.slack.com/services/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
        curl -X POST -H 'Content-type: application/json' --data '{"text":"Hello, World!"}' https://hooks.slack.com/services/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
}
//curl -X POST -H 'Content-type: application/json' --data '{"text":"${messge}"}' https://hooks.slack.com/services/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
