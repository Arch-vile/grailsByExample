package grailsbyexample

/**
 * Controller set as default in the URLMappings.groovy:
 * "/"(controller: "default")
 * @author rapsu
 *
 */
class DefaultController {

    EchoService echoService

    def defaultAction() {
    }


    def returnsModel() {
        return [sentence: "How much wood would a woodchuck chuck"]
    }

    def returnsModelAndView() {
        render view: 'myView', model: [sentence: "If woodchuck could chuck wood"]
    }

    def echoMe(whatToEcho) {
        echoService.echo(whatToEcho)
    }
}
