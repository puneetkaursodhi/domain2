package bootcamp

import grails.test.mixin.TestFor
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

class EmployeeSpec extends Specification {

    void "test"(){
        expect:
            true
    }

    @Unroll("Executing #sno")
    void "test employee validations"() {
        setup:
        Employee employee = new Employee(firstName: fname, lastName: lname, email: email, password: password)
        when:
        Boolean result = employee.validate()

        then:
        result == valid
        where:
        sno | fname     | lname   | email     | password  | valid
        1   | ""        | "hello" | "a@b.com" | "test123" | false
        1   | "Neha"    | "hello" | "puneet"  | "test123" | false
        1   | "test123" | "hello" | "puneet"  | "test123" | false
    }

    def "Email address of employee should be unique"() {
        setup:
        String email = "puneet@tothenew.com"
        String password = 'password'
        Employee employee = new Employee(firstName: "Puneet", lastName: "Kaur", email: email, password: password)

        when:
        employee.save()

        then:
        employee.count() == 1

        when:
        Employee newEmployee = new Employee(firstName: "Neha", lastName: "Gupta", email: email, password: password)
        newEmployee.save()

        then:
        Employee.count() == 1
        newEmployee.errors.allErrors.size() == 1
        newEmployee.errors.getFieldErrorCount('email') == 1
    }

    def "Get user full name"() {
        expect:
        new Employee(firstName: firstName, lastName: lastName).fullName == name

        where:
        firstName | lastName | name
        "puneet"  | "kaur"   | "puneet kaur"
        ""        | "kaur"   | "kaur"
        null      | "kaur"   | "kaur"
        "neha"    | ""       | "neha"
        "neha"    | null     | "neha"
        null      | null     | ""
    }

}
