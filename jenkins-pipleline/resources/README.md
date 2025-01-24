# Shared Jenkins Pipeline Library

This is a shared pipeline library for Jenkins that contains common functions used by multiple Jenkins jobs.

### Functions:

- `sendLarkAlarm`: Sends a failure notification to a Lark bot.

### Setup:

1. Create a webhook in Lark and use it in the `sendLarkAlarm` function.
2. Integrate this library in your Jenkins job by using `@Library('my-shared-library')`.

### Example usage:

```groovy
@Library('my-shared-library') _

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    // Simulate failure
                    error "Build failed"
                }
            }
        }
    }

    post {
        failure {
            script {
                sendLarkAlarm('your_lark_url', ${currentBuild.fullDisplayName}, ${currentBuild.result})
            }
        }
    }
}
