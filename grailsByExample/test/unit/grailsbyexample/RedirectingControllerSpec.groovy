package grailsbyexample

import grails.test.mixin.*
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RedirectingController)
class RedirectingControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "redirect to default controller"() {

        when: "action that redirects to defaul controller"
        controller.redirectToDefaultController()

        then: "mapped to root context"
        response.redirectUrl == "/"
    }

    void "redirect to other controller"() {

        when: "action that redirects to other controller"
        controller.redirectToOtherController()

        then:
        response.redirectUrl == "/chaining"
    }
}