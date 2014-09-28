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

        when: 'bind and validate'
        PaintCommand command = new PaintCommand(color: "red", opacity: -10);
        command.validate()

        then: 'constaint errors'
        command.errors.allErrors.size() == 1
        command.errors.fieldErrors.get(0).getCode() == "range.toosmall"
    }
}
