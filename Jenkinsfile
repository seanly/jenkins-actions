library(
  identifier: 'jenkins-actions@main',
  retriever: modernSCM(
    [$class: 'GitSCMSource',
      remote: 'https://github.com/seanly/jenkins-actions.git'
    ]
  )
)

pipeline {
    agent any
    stages {
        stage('Checkout Actions') {
            steps {
                script {
                    checkoutActions('github.com/seanly/jenkins-actions@main')
                }
            }
        }
        stage('Run Hello Action') {
            steps {
                runAction('hello', ["name=world", "world=hello"])
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
