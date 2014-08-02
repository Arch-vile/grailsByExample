package grailsbyexample

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(DefaultController)
class DefaultControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Calling an action returning a model"() {
		
		when: 'Controller action that returns only a model'
		def model = controller.returnsModel()
		
		then: 'Model populated'
		model.sentence == "How much wood would a woodchuck chuck"
		
    }
	
	void "Calling an action returning model and view"() {
		
		when: 'Controller action that uses render method'
		controller.returnsModelAndView()
		
		then: 'Model populated'
		model.sentence == "If woodchuck could chuck wood"
		
	}
}
