pipeline {
    agent any
    
    tools {
        // Chỗ này phải khớp chính xác với cái Name bạn đặt ở bước trên
        jdk 'Java25_Auto' 
        maven 'M3'
    }

    stages {
        stage('Kiểm tra môi trường') {
            steps {
                echo 'Đang khởi chạy hệ thống với Java 25.0.2+10'
                sh 'java -version'
                sh 'mvn -version'
            }
        }
    }
}