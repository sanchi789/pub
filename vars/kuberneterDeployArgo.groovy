def call(String helmRepoLink, String valuesFilePath, String newImageTag) {
//     def appName = "my-app"             // Set the application name
//     def namespace = "argocd"          // Set the namespace to deploy the application
//     def repoName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('.'))
//     def chartName = helmRepoLink.substring(helmRepoLink.lastIndexOf('/') + 1, helmRepoLink.lastIndexOf('-'))
    appName = env.app_name
    namespace = env.ns
    repoName = env.repo
    chartName = env.chart

//     stage("Checkout") {
//         git url: "git@github.com:<your-repo>/<your-app>.git", branch: "main", credentialsId: gitSecret
//     }

    stage("Update values.yaml") {
        sh "sed -i -E 's/tag: [^ ]*/tag: \"${newImageTag}\"/' ${valuesFilePath}"
       // sed -i -E 's/tag: [^ ]*/tag: "${DOCKER_IMAGE_TAG}"/' 'apps/charts/${App_Name}/values.yaml'
    }


    stage("Helm upgrade") {
        //sh "helm upgrade --install ${appName} ${repoName}/${chartName} --namespace ${namespace} -f ${valuesFilePath}"
        sh "helm install ${chartName} ${appName}"
        //sh "helm upgrade ${appName}"

    }

//     stage("Argo CD sync") {
//         def syncResult = sh(script: "argocd app sync ${appName} --namespace ${namespace}", returnStatus: true)
//         if (syncResult != 0) {
//             error "Failed to sync Argo CD application"
//         }
//     }
}
