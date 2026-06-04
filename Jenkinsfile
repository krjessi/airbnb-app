pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checkout Completed'
            }
        }

        stage('Build Application') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Verify Artifact') {
            steps {
                sh 'ls -lh target/'
            }
        }
    }
}
