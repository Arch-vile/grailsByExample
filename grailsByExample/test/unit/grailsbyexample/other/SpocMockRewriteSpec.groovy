
package grailsbyexample.other

import grails.test.mixin.*
import grailsbyexample.EchoService
import spock.lang.Ignore
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
class SpocMockRewriteSpec extends Specification {

    EchoService echoService = Mock(EchoService)

    def setup() {
        echoService.echo(_) >> "Knock knock"
    }

    def cleanup() {
    }

    void "Mock works"() {

        when:
        def response = echoService.echo("foo")

        then:
        response == "Knock knock"
    }

    @Ignore('does not work')
    void "Mock override that does not work"() {

        setup:
        echoService.echo(_) >> "Who is there?"

        when:
        def response = echoService.echo("foo")

        then:
        response == "Who is there?"
    }

    void "Mock override that works"() {

        when:
        def response = echoService.echo("foo")

        then:
        echoService.echo(_) >> "Who is there?"
        response == "Who is there?"
    }
}

