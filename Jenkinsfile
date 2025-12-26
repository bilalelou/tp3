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
                bat 'mkdir out'
                bat 'javac -d out src/main/java/com/example/*.java'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'java -cp out com.example.Main'
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
