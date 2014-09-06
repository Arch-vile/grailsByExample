package grailsbyexample.unit.views

import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import grailsbyexample.SimpleCommand
import spock.lang.Specification

@TestMixin(GroovyPageUnitTestMixin)
class ViewSpec extends Specification {

    void "form actions prefixed with /test"() {

        when: 'Form is rendered'
        def output = render(view: '/myView')

        then: 'Form action is prefixed with /test'
        assert output.contains('<form action="/test/myAction"')
    }

    void "Text input displays binded value"() {

        setup: 'Input has binded value'
        def model = [
            command: new SimpleCommand(location: "Yellowstone")
        ]

        when: 'View is rendered'
        def output = render(view: '/myView', model: model)
        println output

        then: 'Name value is displayed'
        assert output =~ /<input(.*?)name="location"(.*?)value="Yellowstone"/
    }
}
