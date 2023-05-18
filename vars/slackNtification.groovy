def call(String channel,String token,String message)
{
   post{
        success{
            slackSend( channel: "slacknotification", token: "slackcred", message: "hello everyone Build completed!!1")
           // slackSend(baseUrl: "https://app.slack.com/client/T056YMQQVE1/C0583BMDLTT", teamDomain: "ag-6vd6916", channel: "slacknotification", color: "good", botUser: "false", token: "slackcred", notifyCommitters: "false", iconEmoji: "", username: "", timestamp: "",message: "hi everyone build completed!!")
        }
         success{
            slackSend( channel: "slacknotification", token: "slackcred", message: "hello everyone Build completed!!1")
           // slackSend(baseUrl: "https://app.slack.com/client/T056YMQQVE1/C0583BMDLTT", teamDomain: "ag-6vd6916", channel: "slacknotification", color: "good", botUser: "false", token: "slackcred", notifyCommitters: "false", iconEmoji: "", username: "", timestamp: "",message: "hi everyone build completed!!")
        }
    }
}
