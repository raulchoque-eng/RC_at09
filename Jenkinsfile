pipeline {
    agent any

    stages {       
        stage('Assemble') {
            steps {
                sh './quickstart/gradlew assemble -p quickstart/'
                archiveArtifacts 'quickstart/build/libs/*.jar'
            }
        }        
        stage('Test Unit') {
            parallel {
                stage('Test 1') {                    
                    steps {
                        echo 'test 1'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                    post {
                        always {
                            junit "quickstart/build/test-results/test/*.xml"
                            archiveArtifacts 'quickstart/build/reports/tests/test/*'
                        }
                    }
                }
                stage('Test 2') {                        
                    steps {
                        echo 'test 2'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                }
            }
        }    
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        } 
        stage('Code Analysis') {
            steps {
                echo 'Execute code analysis....'
                sh './quickstart/gradlew check -p quickstart/'
            }            
        }   
    }
    post {
        always {
            mail to: 'raul.choque@fundacion-jala.org',
                 subject: "Successfull Pipeline: ${currentBuild.fullDisplayName}",
                 body: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
        }
    }
}
