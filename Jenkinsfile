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
        sh 'echo "Deploying to ${env.DEPLOY_ENV}..."'
        sh 'mvn tomcat7:redeploy'
      }
    }
  }
  post {
//    always {
//      echo 'This will always run aka. "always"'
//    }

    success {
      echo 'The build is successful :-)'
    }

    failure {
      echo 'The build failed :-('
    }

    unstable {
      echo 'The build unstable'
    }

//    changed {
//      echo 'This will run only if the state of the Pipeline has changed aka. "changed"'
//      echo 'For example, if the Pipeline was previously failing but is now successful'
//    }
  }
}