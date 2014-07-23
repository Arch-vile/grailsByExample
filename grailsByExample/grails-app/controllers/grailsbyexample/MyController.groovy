package grailsbyexample

class MyController {

    def index() {
		
	}
	
	def actionWithoutReturnValue() {
		
	}
	
	def doesChain() {
		chain action: 'actionWithoutReturnValue', model: [name: "my name"]
	}
}
