package grailsbyexample

class RedirectingController {

    def redirectToDefaultController() {
        redirect(controller: "default")
    }

    def redirectToOtherController() {
        redirect(controller: "chaining")
    }
}
