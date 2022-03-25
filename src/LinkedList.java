public class LinkedList {
    Node head; // head of list

    // Method to insert a new node
    public void insert(Customer data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty,
        // then make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = this.head;

            while (last.getNextNode() != null) {
                last = last.getNextNode();
            }

            // Insert the new_node at last node
            last.setNextNode(new_node);
        }

        System.out.println("Customer with ID# " + data.getId() + " inserted.");
    }

    // Method to delete a Customer from the LinkedList by ID
    public void removeById(int searchID) {
        // Store head node
        Node currentNode = this.head;
        Node prev = null;

        // If head node itself holds the key to be deleted
        if (currentNode != null && currentNode.getData().getId() == searchID) {
            this.head = currentNode.getNextNode(); // Change the head

            System.out.println("Customer with ID# " + searchID + " deleted.");
            return; // exit the function
        }

        // the ID is somewhere else in the list so search for it,
        // keep track of the previous node as it is needed to change currentNode.next
        while (currentNode != null && !(currentNode.getData().getId() == searchID)) {
            prev = currentNode;
            currentNode = currentNode.getNextNode();
        }

        // If the ID was present, it should be at currentNode
        // Therefore the currentNode shall not be null
        if (currentNode != null) {
            // Since the key is at currentNode
            // Unlink currentNode from linked list
            assert prev != null;
            prev.setNextNode(currentNode.getNextNode());
            System.out.println("Customer with ID# " + searchID + " deleted.");
        }

        // If key was not present in linked list
        if (currentNode == null)
            System.out.println("Customer with ID# " + searchID + " not found.");

        System.out.println();
    }

    // Method to print the LinkedList.
    public void print() {
        Node currentNode = this.head;

        for (int time = 0; time <= 2; time++) {
            System.out.println("Arrivals at t = " + time);
            // Traverse the LinkedList
            while (currentNode != null && currentNode.getData().getTime() == time) {
                System.out.println("[" + currentNode.getData().getId() +
                        ", " + currentNode.getData().getFirstName() + " " + currentNode.getData().getLastName() +
                        ", " + currentNode.getData().getGender() +
                        ", " + currentNode.getData().getFlightNo() +
                        ", " + currentNode.getData().getPriorityNo() + "]"
                );

                // Go to next node
                currentNode = currentNode.getNextNode();
            }
            System.out.println();
        }
    }
}
