package dsapractice.bookproblem;

import java.util.Scanner;

public class Library {

    static Library library;
    static  Scanner s=new Scanner(System.in);

    Book head;
    Book tail;

    public  void insert(String bookname){

        Book newBook =new Book(bookname);

        if (head==null){
            head= newBook;
            tail= newBook;
            return;
        }
        tail.next= newBook;
        newBook.prev=tail;
        tail= newBook;
    }

    public  String previousBook(String bookName){

        if (head==null){
            return "empty";
        }
        if (head.bookName.equals(bookName)){
            System.out.println("It doesnt contain previous book");
            return"empty";
        }

        Book temp=head;

        while (temp!=null){
            if (temp.bookName.equals(bookName)){
                return temp.prev.bookName;
            }
            temp=temp.next;
        }
        return "empty";
    }

    public  String nextBook(String bookName){

        if (head==null){
            return"empty";
        }
        if (tail.bookName.equals(bookName)){
            return"empty";
        }

        Book temp=head;

        while (temp!=null){
            if (temp.bookName.equals(bookName)){
                return temp.next.bookName;
            }
            temp=temp.next;
        }
return "empty";
    }

    public  String firstBook(){
        if (head==null){
            System.out.println("empty library");
            return "empty";
        }
        return head.bookName;

    }
    public  String lastBook(){
        if (tail==null){
            System.out.println("empty library");
            return " ";
        }
        return  tail.bookName;
    }


    public  void showAllBooks(){

        if (head==null){
            System.out.println("Library is Empty");
            return;
        }
        Book t=head;

        while (t!=null){
            System.out.println( t.bookName);
            t=t.next;
        }
    }

    public static void main(String[] args) {

        library =new Library();
        library.insert("Tamil");
        library.insert("English");
        library.insert("Maths");
        library.insert("Science");
        library.insert("Social");

        System.out.println("press s for showing the first book\n");
        String sc=s.next().toLowerCase();

        while (true){

            switch (sc){

                case "s":
                    System.out.println(library.firstBook());
                    library.bookSearch(library.firstBook());
                    return;

                default:
                    System.out.println("press correct alphabet");

            }
        }
    }

    public  void  bookSearch(String f){

  while (true) {

      System.out.print("\npress p for previous book\npress n for next book\n press c for close\n\n");
      String pn = s.next().toLowerCase();

      switch (pn){

          case "p":

              String d=library.previousBook(f);
              System.out.println(d);
              if (!d.equalsIgnoreCase("empty"))f=d;
              break;


          case "n":

              String e=  library.nextBook(f);
              System.out.println(e);
              if (!e.equalsIgnoreCase("empty"))f=e;
              break;

          case "c":
              return;

          default:

              System.out.println("wrong input");
              break;
            }
        }
    }
}
