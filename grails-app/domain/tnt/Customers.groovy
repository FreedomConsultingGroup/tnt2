package tnt
/**
 * The Customers entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Customers {
    static hasMany = [documents: Documents]
 //   static transactional = false
    static mapping = {
         table 'customers'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         autoTimestamp true
         //documents insertable: false
         //documents updateable: false
    }
    String userid
    String lastName
    String firstName
    Date lastLogin=new Date()
    Date dateCreated
    Date lastUpdated

    static constraints = {
        userid(size: 1..25, blank: false)
        lastName(size: 1..100, blank: false)
        firstName(size: 1..100, blank: false)
        lastLogin(display:false,blank:false)
    
    }
    String toString() {
        return "${id} ${lastName}" 
    }
}
