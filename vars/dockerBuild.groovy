def dockerFilePath = "docker/Dockerfile"
def appName = env.JOB_NAME.split("/").last()
def dockerRepoLink = env.DOCKER_REPO_LINK
