package clases

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TroncalServiceSpec extends Specification {

    TroncalService troncalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Troncal(...).save(flush: true, failOnError: true)
        //new Troncal(...).save(flush: true, failOnError: true)
        //Troncal troncal = new Troncal(...).save(flush: true, failOnError: true)
        //new Troncal(...).save(flush: true, failOnError: true)
        //new Troncal(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //troncal.id
    }

    void "test get"() {
        setupData()

        expect:
        troncalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Troncal> troncalList = troncalService.list(max: 2, offset: 2)

        then:
        troncalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        troncalService.count() == 5
    }

    void "test delete"() {
        Long troncalId = setupData()

        expect:
        troncalService.count() == 5

        when:
        troncalService.delete(troncalId)
        sessionFactory.currentSession.flush()

        then:
        troncalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Troncal troncal = new Troncal()
        troncalService.save(troncal)

        then:
        troncal.id != null
    }
}
