import bootcamp.Airport
import bootcamp.Employee
import bootcamp.Flight
import bootcamp.Location

class BootStrap {

    def init = { servletContext ->
        5.times {
            new Employee(firstName: "Test-${it}", lastName: "user", email: "test-${it}@gmail.com", password: 'igdefault', confirmPassword: 'igdefault').save(failOnError: true)
        }
        10.times {
            new Location(city: "city${it}", country: "country${it}").save()
        }
        Airport airport = new Airport(name: "Delhi Airport")
        5.times {
            airport.addToFlights(new Flight(number: "Flight-${it}", destination: Location.first()))
        }
        airport.save(failOnError: true)
    }
    def destroy = {
    }
}
