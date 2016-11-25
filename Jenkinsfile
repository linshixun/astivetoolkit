node {
    stage 'Checkout'
    deleteDir()                                            // Cleanup workspace
    checkout scm

    stage 'Installing Libs'
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn -q install assembly:assembly -DskipTests=true"
}
