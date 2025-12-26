pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                bat 'echo "Deploying application..."'
            }
        }
    }
}
