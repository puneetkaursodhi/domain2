package bootcamp

class Flight {
    String number
    Location destination

    static belongsTo = [airport: Airport]

    static constraints = {
    }
    static mapping = {
        destination fetch: 'join'
    }
}
