pipeline {
    agent any

    environment {
        SONAR_PROJECT_KEY = "tp4-java-project"
    }

    stages {
        stage('Setup Environment') {
            steps {
                // This retrieves your secret and maps it to the GITHUB_TOKEN variable
                withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {
                    bat 'echo Token retrieved successfully but masked in logs'
                }
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bilalelou/tp3.git'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn -B clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat """
                        mvn -B sonar:sonar ^
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY}
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            echo "✅ TP4 réussi : Qualité OK, pipeline validé"
        }
        failure {
            echo "❌ Pipeline bloqué : tests ou Quality Gate en échec"
        }
    }
}