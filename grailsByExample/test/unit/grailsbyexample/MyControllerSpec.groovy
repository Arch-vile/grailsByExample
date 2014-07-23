package grailsbyexample

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MyController)
class MyControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Action doing chain"() {
		
		when:
		controller.doesChain()
		
		then: 'the model is as expected'
		controller.chainModel.name == "my name"
		
		and: 'the redirect url is as expected'
		response.redirectUrl == '/my/actionWithoutReturnValue'
    }
}
