def call(String helmRepoLink, String valuesFilePath, String newImageTag) {

 oldTag = sh(script: "grep -i \"image:\" ${filePath} | cut -d : -f 3" , returnStdout: true).trim()
 sh "sed -i \'s/${oldTag}/${newImageTag}/g\' ${valuesFilePath}"
  
sh '''
git add .
git status
git push --set-upstream origin main
git commit -m "Publish new version"
git push
'''
}
