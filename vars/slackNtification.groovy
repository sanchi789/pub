def call(String channels,String tokens,String messages,String isSuccess)
{
   
   if("${isSuccess}"==true){
        
               slackSend( channel: "${channels}", token: "${tokens}", message: "${messages}")

      }
      else{
               slackSend( channel: "${channels}", token: "${tokens}", message: "${messages}")
    
   }
}
