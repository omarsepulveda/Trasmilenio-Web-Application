package clases

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Troncal)
interface TroncalService {

    abstract Troncal find(String nombre_troncal)

    Troncal get(Serializable id)

    List<Troncal> list(Map args)

    Long count()

    void delete(Serializable id)

    Troncal save(Troncal troncal)

}