package grailsbyexample

import grails.test.mixin.TestFor
import spock.lang.Specification

import static spock.util.matcher.HamcrestSupport.that
import static org.hamcrest.Matchers.contains

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(InterceptorController)
class InterceptorControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
	
	void "After interceptor applied to correct actions"() {
		
		expect: 'Interceptor method is the correct one'
		controller.afterInterceptor.action.method == "interceptAfter"
		
		and: 'Interceptor is applied to correct action'
		that controller.afterInterceptor.only, contains('actionWithAfterInterceptor','someOther')
	}

    void "Verify interceptor functionality"() {
		
		when: 'After interceptor is applied to the model'
		def model = [firstName: "Guybrush"]
		controller.afterInterceptor.action.doCall(model)
		
		then: 'Model is modified as expected'
		model.firstName == "Guybrush"
		model.lastName == "Threepwood"
    }
	
	void "Verify there is no before interceptor"() {
		expect: 'There is no before interceptor'
		!controller.hasProperty('beforeInterceptor')
	}
}
