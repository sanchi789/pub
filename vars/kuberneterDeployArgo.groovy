def call(String helmRepoLink, String valuesFilePath, String newImageTag) {
//     def appName = "my-app"             // Set the application name
//     def namespace = "default"          // Set the namespace to deploy the application
//     def repoName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('.'))
//     def chartName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('-'))

//     stage("Checkout") {
//         git url: "git@github.com:<your-repo>/<your-app>.git", branch: "main", credentialsId: gitSecret
//     }

    stage("Update values.yaml") {
        sh "sed -i -E 's/tag: [^ ]*/tag: \"${newImageTag}\"/' ${valuesFilePath}"
    }


//     stage("Helm upgrade") {
//         sh "helm upgrade --install ${appName} ${repoName}/${chartName} --namespace ${namespace} -f ${valuesFilePath}"
//     }

//     stage("Argo CD sync") {
//         def syncResult = sh(script: "argocd app sync ${appName} --namespace ${namespace}", returnStatus: true)
//         if (syncResult != 0) {
//             error "Failed to sync Argo CD application"
//         }
//     }
}
