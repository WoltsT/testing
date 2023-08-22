pipeline {
    agent any
    
    environment {
        XAMPP_PATH = 'C:/Users/jmontes/Downloads'
        APACHE_BIN = "C:/xamppapache/bin"
        HTDOCS_DIR = "C:/xampp/htdocs/my-static-website"
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
                       sh "cat ${XAMPP_PATH}"
                        //sh "cp -r /* ${HTDOCS_DIR}"  
                        //sh "${APACHE_BIN}/apachectl restart"  // Reiniciar el servidor Apache
                    }
                }
            }
        }
    }
