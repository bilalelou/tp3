pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-24' // Adjust this path if your JDK is elsewhere
    }

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvnw.cmd test'
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
