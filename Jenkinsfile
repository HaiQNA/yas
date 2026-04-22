pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        stage('Media Service Pipeline') {
            // Vẫn giữ tính năng chỉ chạy khi thư mục media có thay đổi (Yêu cầu 6)
            when { changeset "services/media/**" }
            stages {
                stage('Test & Coverage') {
                    steps {
                        echo 'Đang chạy Unit Test và đo độ phủ cho Media Service...'
                        sh 'mvn -f services/media/pom.xml clean test'
                    }
                    post {
                        always {
                            // Yêu cầu 5: Thu thập kết quả test
                            junit 'services/media/target/surefire-reports/*.xml'
                            
                            // Yêu cầu 7b: Cấu hình JaCoCo và chặn ngưỡng 70%
                            jacoco(
                                execPattern: 'services/media/target/jacoco.exec',
                                instructionCoverageThreshold: '70',
                                lineCoverageThreshold: '70'
                            )
                        }
                    }
                }
                stage('Build') {
                    steps {
                        echo 'Test Pass! Đang đóng gói Media Service...'
                        sh 'mvn -f services/media/pom.xml clean package -DskipTests'
                    }
                }
            }
        }
    }
}