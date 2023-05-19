// import groovy.json.JsonOutput
// import org.apache.http.HttpEntity
// import org.apache.http.client.methods.CloseableHttpResponse
// import org.apache.http.client.methods.HttpPost
// import org.apache.http.entity.ContentType
// import org.apache.http.entity.StringEntity
// import org.apache.http.impl.client.CloseableHttpClient
// import org.apache.http.impl.client.HttpClients

// def call(String webhookUrl, String message) {
//   def httpClient = HttpClients.createDefault()

//   try {
//     def json = [:]
//     json['text'] = message
//     def body = JsonOutput.toJson(json)

//     def httpPost = new HttpPost(webhookUrl)
//     httpPost.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON))

//     CloseableHttpResponse response = httpClient.execute(httpPost)
//     try {
//       def statusCode = response.getStatusLine().getStatusCode()
//       if (statusCode != 200) {
//         error("Failed to send Google Chat notification. Status code: ${statusCode}")
//       }
//     } finally {
//       response.close()
//     }
//   } finally {
//     httpClient.close()
//   }
// }

def getBuildUser() {
    return currentBuild.rawBuild.getCause(Cause.UserIdCause).getUserId()
}

def call(String webhookUrl) {
   BUILD_USER = getBuildUser()
 def message= "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} by ${BUILD_USER}\n More info at: ${env.BUILD_URL}"
  //sh 'curl -X POST -H 'Content-Type: application/json' -d '{\"text\": \"${message}"\}' "${webhookUrl}"'
//   sh "curl -X POST -H 'Content-Type: application/json' -d '{\"text\": \"${message}\"}' ${webhookUrl}"
  String curlCommand = "curl -X POST -H 'Content-Type: application/json' -d '{\"text\": \"${message}\"}' ${webhookUrl}"
  sh curlCommand


}




