package grailsbyexample.commands

import grails.test.mixin.*
import grailsByExample.commands.PaintCommand
import grailsbyexample.DefaultController
import spock.lang.Specification


@TestFor(DefaultController)
class PaintCommandSpec extends Specification {

    void "Verify that request parameters are sucessfully bind to command"() {

        setup: 'set request parameter to bind'
        def params = [:]
        params.color = "red"
        params.opacity = 10

        when: 'bind parameters'
        PaintCommand command = new PaintCommand();
        controller.bindData(command,params)
        command.validate()

        then: 'successfully binded'
        !command.hasErrors()
        command.color == "red"
    }

    void "Verify constraints"() {

        setup: 'set request parameter to bind'
        def params = [:]
        params.color = "red"
        params.opacity = -10 // this will violate constraint

        when: 'bind parameters'
        PaintCommand command = new PaintCommand();
        controller.bindData(command,params)
        command.validate()

        then: 'constaint errors'
        command.hasErrors()
        command.errors.fieldErrors.get(0).getCode() == "range.toosmall"
    }
}
