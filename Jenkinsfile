pipeline {
    agent { label 'agent1' }

    environment {
            GRADLE_REMOTE_CACHE_URL = 'http://192.168.0.109:5071/cache/'
            GRADLE_REMOTE_CACHE_USERNAME = 'user102'
            GRADLE_REMOTE_CACHE_PASSWORD = 'Cache#2025'
            GRADLE_REMOTE_CACHE_PUSH = 'true'
        }

    tools {
        git 'Default'
    }

    stages {
        stage('Prepare Environment') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                }
            }
        }

        stage('Debug Env') {
                    steps {
                        sh 'echo URL=$GRADLE_REMOTE_CACHE_URL'
                        sh 'echo USER=$GRADLE_REMOTE_CACHE_USERNAME'
                        sh 'echo PASS=$GRADLE_REMOTE_CACHE_PASSWORD'
                        sh 'echo PUSH=$GRADLE_REMOTE_CACHE_PUSH'
                    }
                }

        stage('Checkstyle Main') {
            steps {
                script {
                    sh './gradlew checkstyleMain'
                }
            }
        }
        stage('Checkstyle Test') {
            steps {
                script {
                    sh './gradlew checkstyleTest'
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    sh './gradlew compileJava'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
        stage('JaCoCo Report') {
            steps {
                script {
                    sh './gradlew jacocoTestReport'
                }
            }
        }
        stage('JaCoCo Verification') {
            steps {
                script {
                    sh './gradlew jacocoTestCoverageVerification'
                }
            }
        }
    }
    post {
        always {
            script {
                def buildInfo = "Build number: ${currentBuild.number}\n" +
                                "Build status: ${currentBuild.currentResult}\n" +
                                "Started at: ${new Date(currentBuild.startTimeInMillis)}\n" +
                                "Duration so far: ${currentBuild.durationString}"
                telegramSend(message: buildInfo)
            }
        }
    }
}
