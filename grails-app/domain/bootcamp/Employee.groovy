package bootcamp

class Employee implements Serializable {
    String firstName
    String lastName
    String email
    String password
    Date dateCreated
    Date lastUpdated

    String toString() {
        firstName
    }

    static transients = ['fullName']

    static mapping = {
        table "people"
        firstName column:'fname'
        version false
        id composite: ['firstName', 'lastName']
    }

    static constraints = {
    }

    String getFullName() {
        return "${firstName} ${lastName}"
    }
}
