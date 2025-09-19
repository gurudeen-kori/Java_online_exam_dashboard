pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'Maven3'  // Name as configured in Jenkins global tool config
    }

    environment {
        // Sonar server configured in Jenkins -> Configure System
        SONARQUBE_SERVER = 'sonar-server'
        // Sonar token added as credential in Jenkins
        SONARQUBE_TOKEN = credentials('sonar-token-id')
        // OWASP Dependency-Check tool configured in Jenkins
        DEP_CHECK = 'OWASP-DC'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/<your-github-username>/online-exam-dashboard.git'
            }
        }

        stage('Test & Coverage') {
            steps {
                sh 'mvn clean test'
                sh 'mvn jacoco:report'
            }
            post {
                always {
                    // publish test results
                    junit '**/target/surefire-reports/*.xml'
                    // publish coverage (if using cobertura plugin or Jacoco plugin in Jenkins)
                    // e.g., cobertura or other plugin
                }
            }
        }

        stage('OWASP Dependency Check') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ --format XML', odcInstallation: "${env.DEP_CHECK}"
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${env.SONARQUBE_SERVER}") {
                    sh "mvn sonar:sonar -Dsonar.projectKey=online-exam-dashboard -Dsonar.host.url=${env.SONAR_HOST_URL} -Dsonar.login=${env.SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                }
            }
        }

        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def image = docker.build("your-user/online-exam-dashboard:${env.BUILD_NUMBER}")
                    // optionally push to Docker Hub or registry
                    // docker.withRegistry('https://registry.hub.docker.com', 'docker-credentials-id') {
                    //     image.push()
                    // }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
