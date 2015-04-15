package bootcamp

class Employee {
    String firstName
    String lastName
    String email
    String password

    String toString() {
        firstName
    }
    
    static transients = ['fullName']

    static constraints = {
    }

    String getFullName() {
        return "${firstName} ${lastName}"
    }
}
