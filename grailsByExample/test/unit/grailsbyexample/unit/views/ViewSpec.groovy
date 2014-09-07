package grailsbyexample.unit.views

import static com.moonillusions.propertynavigation.PropertyNavigation.of
import static com.moonillusions.propertynavigation.PropertyNavigation.prop
import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import grailsbyexample.SimpleCommand
import spock.lang.Specification

@TestMixin(GroovyPageUnitTestMixin)
class ViewSpec extends Specification {

    void "Form actions prefixed with /test"() {

        when: 'Form is rendered'
        def output = render(view: '/myView')

        then: 'Form action is prefixed with /test'
        assert output.contains('<form action="/test/myAction"')
    }

    void "Text input field mapped to command object"() {

        when: 'View is rendered'
        def output = render(view: '/myView')

        then: 'Input with correct mapping found'
        assert output =~ /<input(.*?)name="color"/

        and: 'Or better with safe property'
        def colorField = prop(of(SimpleCommand.class).color)
        assert output =~ /<input(.*?)name="${colorField}"/
    }

    void "Text input displays binded value"() {

        setup: 'Input has binded value'
        def model = [
            command: new SimpleCommand(color: "red")
        ]

        when: 'View is rendered'
        def output = render(view: '/myView', model: model)

        then: 'Name value is displayed'
        assert output =~ /<input(.*?)name="color"(.*?)value="red"/
    }
}
