def call(String channels,String tokens,String messages,String isSuccess)
{
  
   if("${isSuccess}"==true){
      def successMessage = "*Job Succeeded* :white_check_mark:"
    def formattedMessag = "${successMessage}\n\n> ${messages}"
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessag}")

      }
      else{
         def failureMessage = ":x: *Job Failed* :x:\n\n"
         def formattedMessage = failureMessage + "> ${messages}"
               slackSend( channel: "${channels}", token: "${tokens}", message: "${formattedMessage}")
    
   }
}
