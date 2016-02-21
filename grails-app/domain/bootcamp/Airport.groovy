package bootcamp

class Airport {
    String name
    static hasMany = [flights: Flight]

    static constraints = {

    }

    static mapping = {
        flights lazy: false
    }
}
