sbtPod { label ->
  runInNode(label) {
    container('sbt') {
      injectIvyCredentials()

      stage('Compile') {
        sh 'sbt compile'
      }

      stage('Publish') {
        sh 'sbt publish'
      }
    }
  }
}

nodePod { label ->
  runInNode(label) {
    container('node') {
      npmLogin()

      stage('NPM Install') {
        sh 'npm install'
      }

      stage('Compile') {
        sh 'npm run dist'
      }

      stage('Publish') {
        sh 'npm publish npm-dist'
      }
    }
  }
}
