def call(String channel,String token,String message,boolean isSuccess)
{
   post {
      if(isSuccess==true){
        success {
            script {
                //slackNotification('Build completed', true)
               slackSend( channel: "${channel}", token: "${token}", message: "${message}")
            }
        }
      }
      else{
        failure {
            script {
                //slackNotification('Build failed', false)
               slackSend( channel: "${channel}", token: "${token}", message: "${message}")
            }
        }
    }
   }
}
