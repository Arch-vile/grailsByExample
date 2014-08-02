package grailsbyexample

class ChainingController {

	
    def index() {
		
	}
	
	def actionWithoutReturnValue() {
		
	}
	
	def doesChain() {
		chain action: 'actionWithoutReturnValue', model: [name: "my name"]
	}
	
	def chainToDefaultAction() {
		chain action: 'index'
	}
	
	def chainToDefaultControllerWithDefaultAction() {
		chain controller: 'default', action: 'defaultAction'
	}
	
	def chainToDefaultControllerWithoutAction() {
		chain controller: 'default'
	}
	
}
