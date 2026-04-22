pipeline {
    agent any
    
    tools {
        jdk 'Java21_Auto'
        maven 'M3'
    }

    stages {
        stage('Kiểm tra môi trường') {
            steps {
                // In ra thông tin để chắc chắn mọi thứ đã sẵn sàng
                sh 'java -version'
                sh 'mvn -version'
            }
        }
        
        stage('Build & Test') {
            steps {
                // Thử chạy lệnh Maven để đóng gói dự án
                // -DskipTests là bỏ qua test để build cho nhanh ở bước đầu
                sh 'mvn clean package -DskipTests' 
            }
        }
    }
    
    // Phần bổ sung: Xử lý sau khi xong
    post {
        success {
            echo 'Chúc mừng Hải, mọi thứ chạy mượt mà!'
        }
        failure {
            echo 'Có lỗi rồi, hãy kiểm tra lại code nhé.'
        }
    }
}