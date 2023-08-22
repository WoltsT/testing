pipeline {
    agent any
    
    environment {
        XAMPP_PATH = 'C:\xampp'
        APACHE_BIN = "C:\xampp\apache\bin"
        HTDOCS_DIR = "C:\xampp\htdocs"
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
                        sh "cp -r ./* ${HTDOCS_DIR}/"  // Copiar archivos al directorio htdocs
                        sh "${APACHE_BIN}/apachectl restart"  // Reiniciar el servidor Apache
                    }
                }
            }
        }
    }
}
