package bootcamp

class Book {
    String title
    static belongsTo = [author: Author]
}