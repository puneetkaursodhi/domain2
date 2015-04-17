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
        email(unique: true)
        password(size: 5..15, blank: false,validator:{val, obj ->
            if(val?.equalsIgnoreCase(obj.firstName)) {
                String suggestion = obj.firstName.reverse()
                return ["password.cannot.be.firstname",suggestion]
            }
        })
    }

    String getFullName() {
        return "${firstName} ${lastName}"
    }
}
