pipeline {
    agent any

    environment {
        IMAGE_NAME = "jessemukesh/airbnb-app"
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Build JAR') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Docker Images') {
            steps {
                sh 'docker images | head'
            }
        }
    }
}
