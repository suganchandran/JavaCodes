package dsapractice.linkedlist;

public class SinglyLinkedList {


    private  Node head;
    

    public void insert(int data){

        Node newNode=new Node(data);

        if (head==null){

            head =newNode;
            return;

        }

        Node temp=head;


        while (temp.next!=null){


            temp=temp.next;
        }

        temp.next=newNode;
    }

    public void insertAtBeginning(int data){

        Node newNode=new Node(data);

       newNode.next=head;
        head=newNode;
    }

    public void delete(int key){

        Node temp=head , prev =null;

        if (temp!=null && temp.data==key){
            head=temp.next;
            return;
        }

        while (temp!=null&&temp.data!=key){

            prev=temp;
            temp=temp.next;
            System.out.println(temp.data+"---"+ key);
        }

        if (temp==null)return;

        prev.next=temp.next;
        System.out.println(temp.data+"---"+ temp.next.data);
    }


        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next; // Store next node
                current.next = prev; // Reverse the link
                prev = current; // Move prev one step forward
                current = next; // Move current one step forward
            }

            head=prev;
        }

    public boolean search(int key){

        Node temp=head;

        while (temp!=null){

           if (temp.data==key) {
               return true;
           }

           temp=temp.next;

        }
        return false;
    }

    public void  printList(){

        Node temp=head;

        while (temp!=null){

            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public int size(){
        int count =0;
        Node temp=head;
        while (temp!=null){

            temp=temp.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        SinglyLinkedList list=new SinglyLinkedList();


        list.insert(2);


        list.insert(3);



        list.insert(4);



        list.insert(5);

        list.insertAtBeginning(1);

        System.out.print("Linked List:  ");
        list.printList();

        System.out.println("searching for 4: "+list.search(4));
        System.out.println("Deleting 10....");
        list.delete(2);
        list.printList();

        System.out.println("size :"+list.size());

        list.reverse();
        list.printList();

    }
}
