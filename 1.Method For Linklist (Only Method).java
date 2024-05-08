// HI ,
// --> here only all methods for linklist will be here...
// This is not file only methods are appere see and apply on your code..


---> 1. Insert First.
  
  void insertFirst(int d){

        Node n = new Node(d);

        if(first == null){
            first = n;
        } else {
            n.next = first;
            first = n;
        }
        System.out.println(d+" Is Inserted.");
    }
----------------------------------------------------------------------------------------------
  ---> 2. Insert Last.
  
  void insertLast(int d){
        Node n = new Node(d);
        if(first == null){
            first = n;
        } else {
            Node temp = first;
            while(temp.next!= null){
                temp = temp.next;
            }
            temp.next = n;
        }
    }
----------------------------------------------------------------------------------------------
  ---> 3. Search An Element.
  
  void search(int val){
        Node temp = first;
        int f = 0;
        int c = 0;
        while(temp != null){
            c++;
            if(temp.data == val){
                System.out.println(val+" Value is founded at --> "+c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if(f == 0){
            System.out.println(val+" Value is not found");
        }
    }
----------------------------------------------------------------------------------------------
  ---> 4. Insert Before Any Value.
  
  void insertBeforeValue(int d, int val){
        Node temp = first;
        int f =0;
        int c = 0;
        while(temp != null){
            c++;
            if(temp.data == val){
                System.out.println(val+" Value is founded at --> "+c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if(f == 0){
            System.out.println(val+" Value is not found");
        } else {
            Node n = new Node(d);
            if(first.data == val){
                n.next = first;
                first = n;
            } else {
                Node temp1 = first;
                while(temp1.next.data!= val){
                    temp1 = temp1.next;
                }
                n.next = temp1.next;
                temp1.next = n;
            }
        }
    }
----------------------------------------------------------------------------------------------
  ---> 5. Insert After Any Value.

  void insertAfterValue(int d, int val){
        Node temp = first;
        int f =0;
        int c = 0;
        while(temp != null){
            c++;
            if(temp.data == val){
                System.out.println(val+" Value is founded at --> "+c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if(f == 0){
            System.out.println(val+" Value is not found");
        } else {
            Node n = new Node(d);
            
                Node temp1 = first;
                while(temp1.data!= val){
                    temp1 = temp1.next;
                }
                n.next = temp1.next;
                temp1.next = n;
        }
    }
----------------------------------------------------------------------------------------------
  ---> 6. Delete First Element.

  void deleteFirst(){
        if(first == null){
            System.out.println("List is Empty.");
        } else {
            first = first.next;
        }
        System.out.println("First Node Deleted.");
    }
----------------------------------------------------------------------------------------------
---> 7. Delete Last Element.

  void deleteLast(){
        if(first == null){
            System.out.println("List is Empty.");
        } else if(first.next == null){
            first = null;
        } else {
            Node temp = first;
            while(temp.next.next!= null){
                temp = temp.next;
            }
            temp.next = null;
        }
        System.out.println("Last Node Deleted.");
    }
----------------------------------------------------------------------------------------------
  ---> 8. Delete Any Particular Value.

  void deleteParticularValue(int val){
        Node temp = first;
        int f =0;
        int c = 0;
        while(temp != null){
            c++;
            if(temp.data == val){
                System.out.println(val+" Value is founded at --> "+c);
                f = 1;
                break;
            }
            temp = temp.next;
        }
        if(f == 0){
            System.out.println(val+" Value is not found");
        } else {
            if(first.data == val){
                first = first.next;
            } else {
                Node temp1 = first;
                while(temp1.next.data!= val){
                    temp1 = temp1.next;
                }
                Node a = temp1.next;
                temp1.next = a.next;
                a.next = null;
            }
        }
    }
----------------------------------------------------------------------------------------------
  ---> 9. Display.

  void display(){
        Node temp = first;
        if(first == null){
            System.out.println("List is Empty.");
        } else {

            while(temp!= null){
                System.out.print(temp.data+" --> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
----------------------------------------------------------------------------------------------
  ---> 10. Display Odd Element.

  void displayOdd(){
        int count = 0;
        Node temp = first;
        if(first == null){
            System.out.println("List is Empty.");
        } else {
            while(temp!= null){
                count++;
                if(count % 2!= 0){                      // For Even Change here (count % 2 == 0)
                    System.out.print(temp.data+" --> ");
                }
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
----------------------------------------------------------------------------------------------
  ---> 11. Display Using Recursion.

  void recursionDisplay(Node temp){
        if(temp!= null){
            System.out.print(temp.data+" --> ");
            recursionDisplay(temp.next);
        } else {
            System.out.println("null");
        }
    }
  ----------------------------------------------------------------------------------------------
    ---> 12. Display Reverse Linklist Using Recursion.

    void reverseDisplay(Node temp){
        if(temp != null){
            reverseDisplay(temp.next);
            System.out.print(temp.data + " <-- ");
        } else {
            System.out.print("null <-- ");
            return;
        }
    }
----------------------------------------------------------------------------------------------
  ---> 13. Sorted Insert.

  void sortedInsert(int d){
        Node n = new Node(d);
        if(first == null || first.data >= n.data){ 
            n.next = first;
            first = n;
        } else {
            Node temp = first;
            while(temp.next!= null && temp.next.data < n.data){
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }
----------------------------------------------------------------------------------------------
  ---> 14. Reverse Linklist Elements.

  
