def call(String helmRepoLink, String valuesFilePath, String newImageTag) {
//     def appName = "my-app"             // Set the application name
//     def namespace = "argocd"          // Set the namespace to deploy the application
//     def repoName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('.'))
// //     def chartName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('-'))
//     appName = env.app_name
//     namespace = env.ns
//     repoName = env.repo
//     chartName = env.chart

//     stage("Checkout") {
//         git url: "git@github.com:<your-repo>/<your-app>.git", branch: "main", credentialsId: gitSecret
//     }

//     stage("Update values.yaml") {
//         sh "sed -i -E 's/tag: [^ ]*/tag: \"${newImageTag}\"/' ${valuesFilePath}"
//        // sed -i -E 's/tag: [^ ]*/tag: "${DOCKER_IMAGE_TAG}"/' 'apps/charts/${App_Name}/values.yaml'
//     }

sh "sed -i -E 's/tag: [^ ]*/tag: \"${newImageTag}\"/' ${valuesFilePath}"
//cat apps/charts/${App_Name}/values.yaml
git config --global user.name "sanchi789"
git config --global user.email "sanchi.sharma1@tothenew.com"
git push --set-upstream origin main
git commit -am "Publish new version" && git push

}
