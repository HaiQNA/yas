pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        // Đưa lệnh dọn dẹp lên đầu tiên, trước cả khi tải code (Checkout)
        stage('Prepare Workspace') {
            steps {
                cleanWs()
                // Tải lại code sau khi đã dọn dẹp sạch sẽ
                checkout scm
            }
        }
        stage('Media Service Pipeline') {
            // Jenkins sẽ chạy nếu có thay đổi trong media
            when { changeset "media/**" }
            stages {
                stage('Test & Coverage') {
                    steps {
                        echo 'Đang chạy Unit Test và đo độ phủ cho Media Service...'
                        sh 'mvn clean test -pl media -am'
                    }
                    post {
                        always {
                            junit 'media/target/surefire-reports/*.xml'
                            jacoco(
                                execPattern: 'media/target/jacoco.exec',
                                instructionCoverageThreshold: '0', 
                                lineCoverageThreshold: '0'
                            )
                        }
                    }
                }
                stage('Build') {
                    steps {
                        echo 'Test Pass! Đang đóng gói Media Service...'
                        sh 'mvn clean package -pl media -am -DskipTests'
                    }
                }
            }
        }
    }
}