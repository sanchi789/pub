def call(String tagName) {
  try {
    sh "git tag ${tagName}"
    sh "git push origin ${tagName}"
  } catch (Exception e) {
    error("Failed to create Git tag: ${tagName}. Error: ${e.message}")
  }
}
