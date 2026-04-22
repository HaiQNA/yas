pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        stage('Media Service Pipeline') {
            // Đã sửa lại đúng tên thư mục là media/**
            when { changeset "media/**" }
            stages {
                stage('Test & Coverage') {
                    steps {
                        echo 'Đang chạy Unit Test và đo độ phủ cho Media Service...'
                        // Đã sửa lại đường dẫn pom.xml
                        sh 'mvn -f media/pom.xml clean test'
                    }
                    post {
                        always {
                            // Đã sửa lại đường dẫn thư mục target
                            junit 'media/target/surefire-reports/*.xml'
                            
                            jacoco(
                                execPattern: 'media/target/jacoco.exec',
                                instructionCoverageThreshold: '70',
                                lineCoverageThreshold: '70'
                            )
                        }
                    }
                }
                stage('Build') {
                    steps {
                        echo 'Test Pass! Đang đóng gói Media Service...'
                        sh 'mvn -f media/pom.xml clean package -DskipTests'
                    }
                }
            }
        }
    }
}