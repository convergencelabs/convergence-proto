node {
  deleteDir()
  withCredentials([[$class: 'StringBinding', credentialsId: 'NpmAuthToken', variable: 'NPM_TOKEN'],
  [$class: 'StringBinding', credentialsId: 'ConvNpmAuthToken', variable: 'C_NPM_TOKEN'],
  [$class: 'UsernamePasswordMultiBinding', credentialsId: 'NexusRepo', usernameVariable: 'NEXUS_USER', passwordVariable: 'NEXUS_PASSWORD']]) {

    stage 'Checkout'
    checkout scm

    gitlabCommitStatus {
	
	  docker.withRegistry('https://nexus.convergencelabs.tech:18443/', 'NexusRepo') {
        def protobuf = docker.image('protobuf')
        protobuf.pull()

        docker.image(protobuf.imageName()).inside {
          stage 'Compile (Protoc)'
          sh '''
            mkdir dist
            mkdir -p src/main/java/com/convergencelabs/messages
            protoc proto_files/test.proto --proto_path=proto_files --java_out=src/main/java/com/convergencelabs/messages --js_out=import_style=commonjs:dist
		  '''
        }
      }
	
      stage 'Setup Registry'
      sh '''
        npm config set registry https://nexus.convergencelabs.tech/repository/npm/
        npm config set //nexus.convergencelabs.tech/repository/npm/:_authToken=$NPM_TOKEN
        npm config set //nexus.convergencelabs.tech/repository/convergence-npm/:_authToken=$C_NPM_TOKEN
      '''

      stage 'NPM Install'
      sh '''
        npm install
      '''

      stage 'Publish'
      sh '''
	    npm run timestamp
        npm publish dist
      '''
    }
  }
  deleteDir()
}
