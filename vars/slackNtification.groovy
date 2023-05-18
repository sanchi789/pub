def call(String channels,String tokens,String messages,String isSuccess)
{
   def successMessage = ":tada: *Job Succeeded* :tada:\n\n"
    def formattedMessage = successMessage + "> ${messages}"
   if("${isSuccess}"==true){
        
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")

      }
      else{
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")
    
   }
}
