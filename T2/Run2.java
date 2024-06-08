import java.util.*;
class MultipleFieldsInSLL
{
    class Node
    {
        String Name;
        int Roll;
        Node next;
        Node (int Roll, String Name)
        {
           this.Roll=Roll;
           this.Name=Name;
		   next=null;
        }
    }
    Node First = null;
    void insertFirst(int Roll, String Name)
    {
        Node p=new Node(Roll, Name);
        if(First == null)
        {
            First =p;
        }
        else
        {
            p.next=First;
            First=p;
        }
    }
    void search()
    {
        Scanner sc = new Scanner(System.in);
        String key= sc.nextLine();
        int flag=0;
        Node Temp=First;
        while(Temp!=null)
        {
            if(key.equals(Temp.Name))
            {
                flag=1;
                System.out.println(Temp.Roll+" is having name "+Temp.Name);
            }
            Temp=Temp.next;
        }
        if(flag==0)
        {
            System.out.println("The Search vlaue does not exist");
        }
    }
    void DisplayData()
    {
        Node Temp=First;
        while(Temp!=null)
        {
            System.out.println(Temp.Roll+" "+Temp.Name);
            Temp=Temp.next;
        }
    }
}
class Run2
{
	public static void main(String args[])
	{
    MultipleFieldsInSLL s1 = new MultipleFieldsInSLL();
    s1.insertFirst(1,"Vismay"); 
    s1.insertFirst(2,"Hiren");
    s1.insertFirst(3,"Jaysan");
    s1.search();
    s1.DisplayData();
	}
}