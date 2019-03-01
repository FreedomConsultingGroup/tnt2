package tnt
/**
 * The Documents entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class Documents {
    static belongsTo = [customer:Customers]
    static mapping = {
         table 'documents'
         // version is set to false, because this isn't available by default for legacy databases
         version false
       //  idCustomers column:'id'
       customers insertable: false
       customers updateable: false
    }
    //Long customersId
    String name
    String description
    String hash
    Date dateUploaded=new Date()
    Date dateModified=new Date()
    String comments
    String storagePath
    // Relation
    Customers customers

    static constraints = {
      //  customersId(max: 9999999999L)
        name(size: 1..100, blank: false)
        description(size: 0..2000)
        hash(size: 0..2000)
        dateUploaded(nullable: true)
        dateModified(nullable: true)
        comments()
        storagePath(size: 0..2000)
       // idCustomers()
    }
    String toString() {
        return "${id}" 
    }
}
