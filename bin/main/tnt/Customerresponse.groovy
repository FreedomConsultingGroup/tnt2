package tnt
/**
 * The Customerresponse entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Customerresponse {
    static mapping = {
         // version is set to false, because this isn't available by default for legacy databases
         version false
         autoTimestamp true
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'customerresponse_sequence']
       //  id generator:'identity', column:'id'
        // id composite:['id'], generator:'assigned'
        // customersIdCustomers column:'customers_id'
         //questionsIdQuestions column:'questions_id'
    }
    String responseComment
    Date dateAnswered=new Date()
    String response
    //Long id
    Date lastUpdated, dateCreated
    Customers customersId
    Questions questionsId

    static constraints = {
        dateAnswered(display:false, blank:false)
        response(size: 0..100)
    }
    String toString() {
        return "${customersId},${questionsId}" 
    }
}
