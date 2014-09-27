package grailsByExample.commands

import grails.validation.Validateable

@Validateable
class PaintCommand {

    String color
    Date when
    Integer opacity

    static constraints = {
        opacity range: 0..100
        when nullable: true
    }
}
