pipeline {
    agent any

    stages {       
        stage('Assemble') {
            steps {
                sh './quickstart/gradlew assemble -p quickstart/'
                archiveArtifacts 'quickstart/build/libs/*.jar'
        }
        stage('Test') {
            parallel {
                state('Test 1') {
                    steps {
                        echo 'test 1'
                        sh './quickstart/gradlew test -p quickstart/'
                    }
                    post {
                        always {
                            junit "quiskstart/build.test/result/test/*.xml"
                            archiveArtifacts 'quickstart/build/reports/tests/test/*'
                        }
                    }             
                }
                state('Test 2') {
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
    }
}
