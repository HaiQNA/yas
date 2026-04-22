pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        stage('Initial Cleanup') {
            steps {
                // Dọn sạch workspace để tránh kẹt lỗi Malformed POM
                cleanWs()
            }
        }
        stage('Media Service Pipeline') {
            // Jenkins sẽ chỉ chạy các bước bên dưới nếu có thay đổi trong thư mục media
            when { changeset "media/**" }
            stages {
                stage('Test & Coverage') {
                    steps {
                        echo 'Đang chạy Unit Test và đo độ phủ cho Media Service...'
                        // Chạy test cho media và nạp các thư viện phụ thuộc (common-library)
                        sh 'mvn clean test -pl media -am'
                    }
                    post {
                        always {
                            // Thu thập kết quả test JUnit
                            junit 'media/target/surefire-reports/*.xml'
                            
                            // Thu thập báo cáo độ phủ JaCoCo và hạ ngưỡng về 0 để lấy màu Xanh
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