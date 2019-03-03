package tnt

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CustomerresponseController {

    CustomerresponseService customerresponseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerresponseService.list(params), model:[customerresponseCount: customerresponseService.count()]
    }

    def show(Long id) {
        respond customerresponseService.get(id)
    }

    def create() {
        respond new Customerresponse(params)
    }

    def save(Customerresponse customerresponse) {
        if (customerresponse == null) {
            notFound()
            return
        }

        try {
            customerresponseService.save(customerresponse)
        } catch (ValidationException e) {
            respond customerresponse.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerresponse.label', default: 'Customerresponse'), customerresponse.id])
                redirect customerresponse
            }
            '*' { respond customerresponse, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerresponseService.get(id)
    }

    def update(Customerresponse customerresponse) {
        if (customerresponse == null) {
            notFound()
            return
        }

        try {
            customerresponseService.save(customerresponse)
        } catch (ValidationException e) {
            respond customerresponse.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerresponse.label', default: 'Customerresponse'), customerresponse.id])
                redirect customerresponse
            }
            '*'{ respond customerresponse, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerresponseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerresponse.label', default: 'Customerresponse'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerresponse.label', default: 'Customerresponse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
