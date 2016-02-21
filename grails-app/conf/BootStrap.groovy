import bootcamp.Employee

class BootStrap {

    def init = { servletContext ->
        5.times{
            new Employee(firstName: "Test-${it}",lastName: "user",email:"test-${it}@gmail.com",password: 'igdefault',confirmPassword: 'igdefault').save(failOnError: true)
        }
    }
    def destroy = {
    }
}
