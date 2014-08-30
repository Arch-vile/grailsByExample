package grailsbyexample.unit.views

import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import spock.lang.Specification

@TestMixin(GroovyPageUnitTestMixin)
class ViewSpec extends Specification {

    void "form actions prefixed with /test"() {

        when: 'Form is rendered'
        def output = render(view: '/myView')

        then: 'Form action is prefixed with /test'
        assert output.contains('<form action="/test/myAction"')
    }
}
