def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}

def call(String webhookUrl) {
      def COLOR_MAP = [
      "SUCCESS": 'good',
      "FAILURE": 'danger',
      "ABORTED": 'warning'
      ]
   BUILD_USER = getBuildUser()
 //def message= "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
     def message= "*${currentBuild.currentResult}:*\n *Job_Name:* ${env.JOB_NAME}\n *Build_Number:* ${env.BUILD_NUMBER} \n *Build By* ${BUILD_USER}\n *More info at:* ${env.BUILD_URL}"
   
//  sh  """
//     curl -XPOST -H 'Content-type: application/json\; charset=UTF-8' -d "{"'"attachments"'": [{"'"color"'": "${COLOR_MAP[currentBuild.currentResult]}", "'"text"'": "${message}" }] }' ${webhookUrl}"
//     """
    
    //curl -XPOST -H 'Content-Type: application/json\; charset=UTF-8' -d "{"'"text"'": "'"Hello from a Python script!"'"}" "https://chat.googleapis.com/v1/spaces/AAAAycUdkuk/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=KNgJ2QhUHmKD0MagNh09wfaSd3slF8-3iuBSNQVHsz0"
    
    sh """
      curl -XPOST -H 'Content-Type: application/json; charset=UTF-8' -d "{"'"text"'": "'"${message}"'"}" ${webhookUrl}
     """
}




