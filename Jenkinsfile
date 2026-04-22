pipeline {
    agent any
    tools {
        jdk 'Java25_Auto'
        maven 'M3'
    }
    stages {
        stage('Test & Coverage') {
            steps {
                echo 'Bắt đầu chạy Test...'
                // Chạy thẳng lệnh Maven tại thư mục media
                // Dùng -pl và -am để nạp common-library
                sh 'mvn clean test -pl media -am'
            }
            post {
                always {
                    // Thu thập báo cáo
                    junit 'media/target/surefire-reports/*.xml'
                    jacoco(
                        execPattern: 'media/target/jacoco.exec',
                        instructionCoverageThreshold: '0', 
                        lineCoverageThreshold: '0'
                    )
                }
            }
        }
    }
}