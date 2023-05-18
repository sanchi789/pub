def call(String channels,String tokens,String messages,String isSuccess)
{
  
   if("${isSuccess}"==true){
         def successMessage = ":tada: *Job Succeeded* :tada:\n\n"
         def formattedMessage = successMessage + "> ${messages}"
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")

      }
      else{
         def failureMessage = ":x: *Job Failed* :x:\n\n"
         def formattedMessage = failureMessage + "> ${message}"
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")
    
   }
}
