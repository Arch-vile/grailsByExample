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

        when: 'Controller action that returns only a model need to explicitly assigned'
        def model = controller.returnsModel()

        then: 'Model populated'
        model.sentence == "How much wood would a woodchuck chuck"
    }

    void "Calling an action returning model and view"() {

        when: 'Controller action that uses render method will be assigned to model variable automatically'
        controller.returnsModelAndView()

        then: 'Model populated'
        model.sentence == "If woodchuck could chuck wood"
    }

    void "Mocking service call"() {

        setup: 'Mock service call'
        EchoService echoService = Mock(EchoService)
        echoService.echo(_) >> { args -> "mocked: " + args[0] }
        controller.echoService = echoService

        expect: 'Mocked method is used'
        controller.echoMe("knock") == "mocked: knock"
    }

    void "Verify service is called with expected arguments"() {

        setup: 'Set mock service'
        EchoService echoService = Mock(EchoService)
        controller.echoService = echoService

        when: 'Controller method is called'
        controller.echoMe("Something to echo")

        then: 'Service called with the same argument'
        1 * echoService.echo({ text ->
            assert text == "Something to echo"
            true
        })
    }
}
