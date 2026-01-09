pipeline {
    agent any

    environment {
        SONAR_PROJECT_KEY = "tp4-java-project"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/bilalelou/tp3.git'
                withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {
                     echo "Token is ready for use in this block"
                }
            }
        }

        stage('Build') {
            steps {
                bat 'call mvnw.cmd -B clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'call mvnw.cmd -B test'
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
                        call mvnw.cmd -B sonar:sonar ^
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY}
                    """
                }
            }
        }
        // stage('SonarQube Quality Gate') {
        //     bat """
        //         mvn clean verify sonar:sonar \
        //         -Dsonar.projectKey=tp3 \
        //         -Dsonar.host.url=http://localhost:9000 \
        //         -Dsonar.login=sqp_031459f9f293025f7c1c09b21905a2ce7c9d04a9
        //     """
        // }
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