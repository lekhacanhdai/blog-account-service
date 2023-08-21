pipeline {
    agent any
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub_user')
    }

    stages {
        stage("Proto Build") {
            agent {
                docker {
                    image 'maven:3.6.3-jdk-11'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                dir("account-grpc"){
                     sh 'mvn -B -DskipTests clean install'
                }
            }
        }
        stage("Maven Build") {
            agent {
                docker {
                    image 'maven:3.6.3-jdk-11'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                dir("account-service"){
                     sh 'mvn -B -DskipTests clean install'
                }
            }
        }
        stage("Docker build") {
            steps {
                dir('account-service'){
                    sh 'docker build -t anhdai0801/blog-account-service:latest .'
                }
            }
        }
        stage("Docker push") {
            steps {
                sh "echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
                sh "docker push anhdai0801/blog-account-service:latest"
                sh "docker rmi anhdai0801/blog-account-service:latest"
            }
        }
    }
}