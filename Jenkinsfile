sbtNodePod { label ->
  runInNode(label) {
    container('sbt') {
      injectIvyCredentials()

      stage('SBT Compile') {
        sh 'sbt -J-Xmx3G -J-Xss5M compile'
      }

      stage('SBT Publish') {
        sh 'sbt publish'
      }
    }

    container('node') {
      npmLogin()

      stage('NPM Install') {
        sh 'npm install'
      }

      stage('NPM Compile') {
        sh 'npm run dist'
      }

      stage('NPM Publish') {
        sh 'npm --registry=https://nexus.dev.convergencelabs.tech/repository/npm-convergence publish npm-dist'
      }
    }
  }
}
