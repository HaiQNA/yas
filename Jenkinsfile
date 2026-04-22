pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        stage('Media Service Pipeline') {
            when { changeset "media/**" }
            stages {
                stage('Test & Coverage') {
                    steps {
                        echo 'Đang chạy Unit Test và đo độ phủ cho Media Service...'
                        // ĐỨNG Ở ROOT, CHỈ ĐỊNH MEDIA VÀ CÁC THƯ VIỆN PHỤ THUỘC
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
                        // TƯƠNG TỰ CHO BƯỚC BUILD
                        sh 'mvn clean package -pl media -am -DskipTests'
                    }
                }
            }
        }
    }
}