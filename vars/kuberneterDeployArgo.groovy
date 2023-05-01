def call(String helmRepoLink, String valuesFilePath, String newImageTag,String gitSecret, String username,String email) {

sh "sed -i -E 's/tag: [^ ]*/tag: \"${newImageTag}\"/' ${valuesFilePath}"

  
sh '''
git add .
git status
git push --set-upstream origin main
git commit -m "Publish new version"
git push
'''
}
