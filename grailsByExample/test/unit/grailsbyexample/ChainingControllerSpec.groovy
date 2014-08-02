package grailsbyexample

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ChainingController)
class ChainingControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Chain to an action"() {
		
		when:
		controller.doesChain()
		
		then: 'the model is as expected'
		controller.chainModel.name == "my name"
		
		and: 'the redirect url is as expected'
		response.redirectUrl == '/chaining/actionWithoutReturnValue'
    }
	
	void "Chains to default action"() {
		
		when: 'Action chaining to default action is called'
		controller.chainToDefaultAction()
		
		then: 'URL is mapped accordingly to the default mapping'
		response.redirectUrl == '/chaining/index'
		
	}
	
	/**
	 * Calls controller method that will chain to the default controller and specifies the default
	 * action
	 */
	void "Chain to default controller and default action"() {
		when: 'Action chaining to the default controller with action defined'
		controller.chainToDefaultControllerWithDefaultAction()
		
		then: 'Full url is used'
		response.redirectUrl == '/default/defaultAction'
		
	}
	
	/**
	 * Calls controller method that will chain to the default controller without specifying
	 * the action to chain to
	 */
	void "Chain to default controller"() {
		when:'Action chaining to the default controller without action defined'
		controller.chainToDefaultControllerWithoutAction()
		
		then: 'Default URL mapping is used'
		response.redirectUrl == '/'
		
	}
}
