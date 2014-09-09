package grailsbyexample

import grails.transaction.Transactional

@Transactional
class EchoService {

    def echo(whatToEcho) {
        whatToEcho
    }
}
