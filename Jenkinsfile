pipeline {
    agent any
    stages {
        stage('Pre') {
            steps {
                sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Here we go..."'
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}
