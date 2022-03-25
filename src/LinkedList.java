public class LinkedList {
    Node head; // head of list

    // Method to insert a new node
    public void insert(Customer data) {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = this.head;

            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        System.out.println("Customer with ID# " + data.getId() + " inserted.");
    }

    // Method to delete a Customer from the LinkedList by ID
    public void removeById(int searchID) {
        // Store head node
        Node currNode = this.head;
        Node prev = null;

        // If head node itself holds the key to be deleted
        if (currNode != null && currNode.data.getId() == searchID) {
            this.head = currNode.next; // Change the head

            System.out.println("Customer with ID# " + searchID + " deleted.");
            return; // exit the function
        }

        // the ID is somewhere else in the list so search for it,
        // keep track of the previous node as it is needed to change currNode.next
        while (currNode != null && !(currNode.data.getId() == searchID)) {
            prev = currNode;
            currNode = currNode.next;
        }

        // If the ID was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            assert prev != null;
            prev.next = currNode.next;
            System.out.println("Customer with ID# " + searchID + " deleted.");
        }

        // If key was not present in linked list
        if (currNode == null)
            System.out.println("Customer with ID# " + searchID + " not found.");

        System.out.println();
    }
    
     public void sortByPriority(){
	    	   Node currNode = this.head, index = null;
	    	   Customer temp;

	    	   if(this.head == null)
	    	       return;
	    	   else {
	    	       while (currNode != null){
	    	           //Node index will point to node next to currNode
	    	           index = currNode.next;

	    	           while (index != null){
	    	               //If current node data is greater than index's node data,
	    	               //swap the data between them
	    	               if(currNode.data.getPriorityNo() > index.data.getPriorityNo()){
	    	                   temp = currNode.data;
	    	                   currNode.data = index.data;
	    	                   index.data = temp;
	    	               }

	    	               index = index.next;
	    	           }
	    	           currNode = currNode.next;
	    	       }
	    	   }
	    	}
	  public void sortByTime(){
	    	   Node currNode = this.head, index = null;
	    	   Customer temp;

	    	   if(this.head == null)
	    	       return;
	    	   else {
	    	       while (currNode != null){
	    	           //Node index will point to node next to currNode
	    	           index = currNode.next;

	    	           while (index != null){
	    	               //If current node data is greater than index's node data,
	    	               //swap the data between them
	    	               if(currNode.data.getTime() > index.data.getTime()){
	    	                   temp = currNode.data;
	    	                   currNode.data = index.data;
	    	                   index.data = temp;
	    	               }

	    	               index = index.next;
	    	           }
	    	           currNode = currNode.next;
	    	       }
	    	   }
	    	}

    // Method to print the LinkedList.
    public void print() {
        Node currNode = this.head;
        System.out.print("Customers: \n");

        // Traverse the LinkedList
        while (currNode != null) {
            System.out.println("[" + currNode.data.getId() +
                    ", " + currNode.data.getFName() + " " + currNode.data.getLName() +
                    ", " + currNode.data.getGender() +
                    ", " + currNode.data.getFlightNo() +
                    ", " + currNode.data.getPriorityNo() + "] Time: "+ currNode.data.getTime()
            );

            // Go to next node
            currNode = currNode.next;
        }

        System.out.println();
    }
}
