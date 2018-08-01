pipeline {
  agent any
  parameters {
      choice(
          name: 'DEPLOY_ENV',
          choices: 'Udvikling\nTest\nStaging\nProduktion',
          description: 'Vælg hvor denne branch skal deployes'
      )
  }

  stages {
    stage('Build') {
      steps {
        sh 'echo "Building..."'
        sh 'mvn clean install -Dmaven.test.skip=true'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        sh 'echo "Deploying..."'
        sh 'mvn tomcat7:redeploy'
      }
    }
  }
  post {
    always {
      echo 'This will always run aka. "always"'
    }

    success {
      echo 'This will run only if successful aka. "success"'
    }

    failure {
      echo 'This will run only if failed aka. "failure"'
    }

    unstable {
      echo 'This will run only if the run was marked as unstable aka. "unstable"'
    }

    changed {
      echo 'This will run only if the state of the Pipeline has changed aka. "changed"'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}