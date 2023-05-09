def call(String webhookUrl, String message) {
  def json = [:]
  json['text'] = message
  def body = JsonOutput.toJson(json)
  def response = httpRequest(url: webhookUrl, contentType: 'APPLICATION_JSON', httpMode: 'POST', requestBody: body)
  if (response.status != 200) {
    error("Failed to send Google Chat notification: ${response.status} ${response.content}")
  }
}
