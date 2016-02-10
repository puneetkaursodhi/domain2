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
        firstName(type: 'text')
    }

    static constraints = {
        email(unique: true, email: true)
        password(size: 5..15, blank: false, validator: { val, obj ->
            if (val?.equalsIgnoreCase(obj.firstName)) {
                String suggestion = obj.firstName.reverse()
                return ["password.cannot.be.firstname", suggestion]
            }
        })
    }

    String getFullName() {
        [firstName, lastName].findAll { it }.join(' ')

    }

    def beforeInsert() {
        println "I am inside before insert"
    }

    def beforeValidate() {
        println "I am inside before validate"
    }

    def beforeUpdate() {
        println "I am inside before update"
    }

    def afterInsert() {
        println "I am inside after insert"
    }

    def afterUpdate() {
        println "I am inside after update"
    }
}
