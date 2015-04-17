package bootcamp

class Face {
//    Nose nose

    static hasOne = [nose:Nose]

    static constraints = {
        nose unique: true
    }
}
