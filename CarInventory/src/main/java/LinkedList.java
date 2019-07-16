

public class LinkedList {
    private int data;
    private LinkedList ref;
    public static LinkedList head;

    // LinkedList head;

    public void add(int num) {

        //LinkedList li = new LinkedList(num, head);

        LinkedList li = new LinkedList();
        li.data = num;
        li.ref = null;
        LinkedList tmp = head;
        LinkedList prev = head;
        //Object obj = new LinkedList();
        if (head != null) {
            // Have to goto the end node using the loop
            while (tmp != null) {
                prev = tmp;
                tmp = tmp.ref;
            }
            // Adding at the end of the list
            prev.ref = li;
            System.out.println("Added: "+ num);

        } else {
            //When there are no elements in the list, make the head point to the created node

            head = li;
            li.ref = null;
            System.out.println("Added: "+ num);
        }


        list();
    }

    public void list() {

        LinkedList li = head;
        System.out.print("Element in the list: ");
        while (li != null) {
            System.out.print(li.data+ "\t");
            li = li.ref;
        }
        System.out.println();

    }

    public void remove(int num) {

        // LinkedList li = head;
        LinkedList prev, current, next;
        prev = current = head;

        next = null;

        if (head == null){
            System.out.println("No elements in the list");
            return;
        }

        while (current != null) {

            // when there are many nodes in the list
            if (current.data ==num) {
                if (current == head){
                    // only one element in the list so make the head point to the next node
                    head = head.ref;
                    System.out.println("Removed: "+ num);
                    current = null;


                }
                else {
                    // when there is more than 1 element in the list

                    if (next == null) { // Executed when there is no node next to the current node

                        prev.ref = null;
                        System.out.println("Removed: "+ num);
                        current = null;

                    }
                    else
                    {
                        // Executed when there is a node next to the current node - the prev node will point to next node
                        prev.ref = next;
                        System.out.println("Removed: "+ num);
                        current = null;
                    }


                }
            }
            else{
                // Executed when the number doesnt match the current node,  current node will become the prev node

                // current node will point to next node
                // next node wil be the node next to the current node

                    prev = current;
                    current = current.ref;
                    if (current.ref != null){
                        next = current.ref;
                    }
                    else {
                        next = null;
                    }

            }

        }
        list();

    }


}
