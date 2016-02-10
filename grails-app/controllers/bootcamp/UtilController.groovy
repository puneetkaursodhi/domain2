package bootcamp

class UtilController {

    def index() {}

    def oneToOne() {
        new Face(nose: new Nose()).save()
//        new Face(nose: Nose.get(1)).save(failOnError: true)
        render "done"
    }

    def deleteWithOneToOne() {
        Face f = Face.get(1L)
        f.delete(failOnError: true, flush: true)
        render "done"
    }

    def oneToMany() {
        new Author(name: "Stephen King")
                .addToBooks(new Book(title: "The Stand"))
                .addToBooks(new Book(title: "The Shining"))
                .save(flush: true)
        render "done"
    }

    def manyToManyWithOwner() {
        new Author(name: "Stephen King")
                .addToBooks(new Book(title: "The Stand"))
                .addToBooks(new Book(title: "The Shining"))
                .save(flush: true)
        render "done"
    }

    def manyToManyWithOwned() {
        new Book(title: "Groovy in Action")
                .addToAuthors(new Author(name: "Dierk Koenig"))
                .addToAuthors(new Author(name: "Guillaume Laforge"))
                .save()
        render "done"
    }

    def testConstraint() {
        Employee employee = new Employee(firstName: "Puneet", lastName: "Kaur", email: "puneet@intelligrape.com",
                password: "puneet")
        employee.validate()
        employee.errors.allErrors.each {
            println "Errors" + it
        }
        render employee.hasErrors()
    }

    def saveFlow() {
        Employee employee = new Employee(firstName: "Puneet", lastName: "Kaur", email: "puneet@intelligrape.com",
                password: "puneet")
        render employee.save(flush: true)

    }

}
