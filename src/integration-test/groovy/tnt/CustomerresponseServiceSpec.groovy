package tnt

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerresponseServiceSpec extends Specification {

    CustomerresponseService customerresponseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Customerresponse(...).save(flush: true, failOnError: true)
        //new Customerresponse(...).save(flush: true, failOnError: true)
        //Customerresponse customerresponse = new Customerresponse(...).save(flush: true, failOnError: true)
        //new Customerresponse(...).save(flush: true, failOnError: true)
        //new Customerresponse(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerresponse.id
    }

    void "test get"() {
        setupData()

        expect:
        customerresponseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Customerresponse> customerresponseList = customerresponseService.list(max: 2, offset: 2)

        then:
        customerresponseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerresponseService.count() == 5
    }

    void "test delete"() {
        Long customerresponseId = setupData()

        expect:
        customerresponseService.count() == 5

        when:
        customerresponseService.delete(customerresponseId)
        sessionFactory.currentSession.flush()

        then:
        customerresponseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Customerresponse customerresponse = new Customerresponse()
        customerresponseService.save(customerresponse)

        then:
        customerresponse.id != null
    }
}
