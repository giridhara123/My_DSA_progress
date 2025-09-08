public class linkedlist {

    // Static inner class so static methods can use it
    static class Node {
        int data;
        Node next;

        Node(int data1) {
            this.data = data1;
            this.next = null;
        }
        Node(int data1, Node next)
        {
            this.data=data1;
            this.next=next;

        }
    }

    private static Node convert(int[] arr) { // converting the array into the linked list.

        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public  static int  ispresent(Node head, int x)// searching the elements in linked list
    {
        Node temp = head;
        while(temp!=null)
        {
        if(temp.data == x) return 1;
        
        temp= temp.next;
        }

        return 0;

    }
    private static void print(Node head) // printing all the elements in linked list
    {
        while(head!=null)
        {
            System.err.println(head.data+" ");
            head=head.next;
        }
    }
    private static Node remove(Node head){ // deleting the head node from the linked list
        if(head==null) return head;
        head= head.next;

        return head;
    }
    private static Node removeTail(Node head)// deleting the tail of linked list.
    {
        Node temp= head;
        while(temp.next.next!=null)
        {
            temp= temp.next;
        }
        temp.next=null;
        return head;
    }
    private static Node removek(Node head, int k) // deleting kth element in the linked list.
    {
        if(head==null) return head;

        if(k==1) // edge case to remove 1st element.
        {
            head=head.next;
            return head;
        }
        int count=0;
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            count++;
            if(count== k)
            {
                prev.next= prev.next.next;
                break;
            }
            prev= temp;
            temp=temp.next;
        }
        return head;
    }
    private static Node removeel(Node head, int k) // deleting particular  element in the linked list.
    {
        if(head==null) return head;

        if(head.data==k) // edge case to remove 1st element.
        {
            head=head.next;
            return head;
        }
       
        Node temp = head;
        Node prev = null;
        while(temp!=null)
        {
            
            if(temp.data== k)
            {
                prev.next= prev.next.next;
                break;
            }
            prev= temp;
            temp=temp.next;
        }
        return head;
    }

    public static Node inserthead(Node head, int  val)// inserting element at head.
    {
       Node temp = new Node(val, head);
        return temp;


    }
    public static Node inserttail(Node head, int val)// insterting element in the tail of linked list;
    {
        if(head== null)
        {
            return new Node(val);
        }
        Node temp= head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        Node node1= new Node(val);
        temp.next=node1;

        return head;

    }

    public static Node insertk(Node head, int el, int k) //inserting element in kth place of linked list.
    {
        if(head==null) // if head is null we will add element if k is only 1.
        {
            if(k==1)
            {
                return new Node(el);
            }
        }
        if(k==1) // if head contains only element and k is 1 we add new element as head
        {
            Node temp = new Node(el, head);
            return temp;
        }

        int count=0; Node temp =head;
        while(temp!=null)// adding element middle of a linked list.
        {
            count++;
            if(count==k-1)
            {
                Node n = new  Node(el);
                n.next=temp.next;
                temp.next=n;
                break;

            }
            temp=temp.next;
        }
        return head;
    }

    public static Node insertatvalue(Node head, int el, int val) // inserting the element at particular value
    {
        if(head==null) 
        {
            return null;
        }
        if(head.data==val) 
        {
            Node temp = new Node(el, head);
            return temp;
        }

         Node temp =head;
        while(temp.next!=null)//
        {
          
            if(temp.next.data==val)//here we should check before reaching to the particular element 
            {
                Node n = new  Node(el);
                n.next=temp.next;
                temp.next=n;
                break;

            }
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8};
       // int x = 12;
        Node head = convert(arr);
       // head= removeTail(head);
      // head = removek(head, 2);
      // head = removeel(head, 8);
      //head= inserthead(head, 20);
     // head= inserttail(head, 100);
    // head =insertk(head, 100,2);
    head = insertatvalue(head, 100, 6);
        print(head);

       /* System.out.println(ispresent( head,x));*/
         
    }
}