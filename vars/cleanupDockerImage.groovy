def call() {
    sh 'docker system prune -a -f --filter "until=24h"'
}
