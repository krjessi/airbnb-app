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

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push $IMAGE_NAME:$IMAGE_TAG'
            }
        }

        stage('Verify Image') {
            steps {
                sh 'docker images | grep airbnb'
            }
        }
	stage('Deploy Application') {
    	    steps {
        	sh '''
                docker pull jessemukesh/airbnb-app:latest

                docker stop airbnb-app || true
                docker rm airbnb-app || true

                docker run -d \
                  --name airbnb-app \
                  --network airbnb-network \
                  -p 8081:8080 \
                  jessemukesh/airbnb-app:latest
                '''
 	   }
	}
    }
}
