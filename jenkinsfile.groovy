pipeline {
    agent any
    
    environment {
        XAMPP_PATH = '/xampp'
        APACHE_BIN = "/xamppapache/bin"
        HTDOCS_DIR = "/xampp/htdocs/my-static-website"
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Deploy to XAMPP') {
            steps {
                script {
                        sh "ls-la"
                        sh "cp -r ./* ${HTDOCS_DIR}"  // Copiar archivos al directorio htdocs
                        sh "${APACHE_BIN}/apachectl restart"  // Reiniciar el servidor Apache
                    }
                }
            }
        }
    }
