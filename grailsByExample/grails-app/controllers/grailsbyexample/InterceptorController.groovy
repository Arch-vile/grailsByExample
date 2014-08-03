package grailsbyexample

class InterceptorController {

	
	def afterInterceptor = [action: this.&interceptAfter, only: ['actionWithAfterInterceptor','someOther']]
	
	private interceptAfter(model) { model.lastName = "Threepwood" }
	
    def index() { }
	
	def actionWithAfterInterceptor() {
		
	}
	
	
}
