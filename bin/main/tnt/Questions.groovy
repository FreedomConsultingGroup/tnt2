package tnt
/**
 * The Questions entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Questions {
    static mapping = {
         // version is set to false, because this isn't available by default for legacy databases
         version false
         // In case a sequence is needed, changed the identity generator for the following code:
//       id generator:'sequence', column:'id', params:[sequence:'questions_sequence']
         id generator:'identity', column:'id'
         autoTimestamp: true
    }
    String question
    String questionDescription
    Date dateCreated
    Date dateUpdated
   // Long questionTypeId
    

    static constraints = {
        question(size: 1..2000, blank: false)
        questionDescription(size: 1..2000, blank: false)
    }
    String toString() {
        return "${id}" 
    }
}
