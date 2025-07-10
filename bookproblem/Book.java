package dsapractice.bookproblem;

public class Book {

    String bookName;
    Book next;
    Book prev;

    public Book(String bookName){

        this.bookName=bookName;
        this.prev=null;
        this.next=null;

    }

}
