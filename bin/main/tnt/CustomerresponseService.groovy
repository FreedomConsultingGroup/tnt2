package tnt

import grails.gorm.services.Service

@Service(Customerresponse)
interface CustomerresponseService {

    Customerresponse get(Serializable id)

    List<Customerresponse> list(Map args)

    Long count()

    void delete(Serializable id)

    Customerresponse save(Customerresponse customerresponse)

}