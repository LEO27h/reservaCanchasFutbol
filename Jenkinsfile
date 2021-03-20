pipeline {
  //Donde se va a ejecutar el Pipeline
/*  agent {
    label 'Slave_Induccion'
  }
*/
  agent any
  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
    gradle 'Gradle4.10.2_Centos' //Preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout'){
            steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/main']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [],
                gitTool: 'Default',
                submoduleCfg: [],
                userRemoteConfigs: [[
                    credentialsId: 'GitHub_leonherrera',
                    url:'https://github.com/LEO27h/reservaCanchasFutbol'
                ]]
            ])
        }
    }

    stage('Clean'){
        steps{
            echo "------------>Clean project<------------"
            sh 'gradle --b ./java-arquitectura-hexagonal/microservicio/build.gradle clean'
        }
    }

//     stage('Static Code Analysis') {
//         steps{
//             echo '------------>Análisis de código estático<------------'
//             withSonarQubeEnv('Sonar') {
//                 sh "${tool name: 'SonarScanner', \
//             type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
//             }
//         }
//     }

    stage('Compile & Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
        sh 'gradle --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
        withSonarQubeEnv('Sonar') {
            sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
         sh 'gradle --b ./microservicio/build.gradle -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'testPrueba/*.xml'
    }
    failure {
        echo 'This will run only if failed'
        mail (to: 'leon.herrera@ceiba.com.co',
    subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
    body: "Something is wrong with ${env.BUILD_URL}")

    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}

