node {
    // Change `url` value to your own
    git url: 'https://github.com/smovse/jenkins_pipeline.git'
    
    def inputParams = inputParamsString()
    
    // Change `message` value to the message you want to display
    // Change `description` value to the description you want
    def selectedProperty = input( id: 'userInput', message: 'Choose properties file', parameters: [ [$class: 'ChoiceParameterDefinition', choices: inputParams, description: 'Properties', name: 'prop'] ])
    
    println "Property: $selectedProperty"
    
    // Change `job` value to your downstream job name
    // Change `name` value to the name you gave the string parameter in your downstream job
    build job: 'downstream-freestyle', parameters: [[$class: 'StringParameterValue', name: 'prop', value: selectedProperty]]
}

@NonCPS
def inputParamsString() {
        def list = []
        list << 'test1'
        list << 'test2'
    }
    
    list.join("\n")
}