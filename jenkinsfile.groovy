pipeline {
    agent any
    
    environment {
        XAMPP_PATH = "xampp/apache"
        APACHE_BIN = "xampp/apache/bin"
        HTDOCS_DIR = "xampp/htdocs/my-static-website"
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
                        //sh "ls-la"
                       bat "dir  ${XAMPP_PATH}"
                        //sh "cp -r /* ${HTDOCS_DIR}"  
                        //sh "${APACHE_BIN}/apachectl restart"  // Reiniciar el servidor Apache
                    }
                }
            }
        }
    }
