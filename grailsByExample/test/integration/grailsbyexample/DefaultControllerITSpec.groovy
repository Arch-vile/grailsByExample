package grailsbyexample



import spock.lang.*

/**
 *
 */
class DefaultControllerITSpec extends Specification {

    DefaultController controller
    EchoService echoService

    def setup() {
        controller = new DefaultController()
        echoService = Mock(EchoService) // Always initialize for each test
        controller.echoService = echoService
    }

    def cleanup() {
    }

    void "Verify service is called with expected arguments"() {
        when: 'Controller method is called'
        controller.echoMe("Something to echo")

        then: 'Service called with the same argument'
        1 * echoService.echo({ text ->
            assert text == "Something to echo"
            true
        })
    }
}
