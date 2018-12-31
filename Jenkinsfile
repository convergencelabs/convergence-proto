sbtPod { label ->
  runInNode(label) {
    container('sbt') {
      injectIvyCredentials()

      stage('SBT Compile') {
        sh 'sbt compile'
      }

      stage('SBT Publish') {
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

      stage('NPM Compile') {
        sh 'npm run dist'
      }

      stage('NPM Publish') {
        sh 'npm publish npm-dist'
      }
    }
  }
}
