import java.util.*;

class Element
{
	protected int data;
	protected Element link;
	public Element()
	{
		link = null;
		data = 0;
	}
	public Element(int data, Element link)
	{
		this.data = data;
		this.link = link;
	}
	public void setData(int data)
	{
		this.data = data;
	}
	public void setLink(Element link)
	{
		this.link = link;
	}
	public int getData()
	{
		return this.data;
	}
	public Element getLink()
	{
		return this.link;
	}	
}

class LinkedListOperations
{
	protected Element front, back;
	public int size;
	public LinkedListOperations()
	{
		front = null;
		back = null;
		size = 0;
	}
	public boolean isEmpty()
	{
		if(front == null)
			return true;
		else return false;
	}
	public int getSize()
	{
		return size;
	}
	public void insert(int data)
	{
		Element ptr = new Element(data, null);
		if(back == null)
		{
			front = ptr;
			back = ptr;
		}
		else
		{
			back.setLink(ptr);
		}
		size++;
	}
	public int remove()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception\n");
		Element ptr = front;
		front = ptr.getLink();
		if(front == null)
			back = null;
		size--;
		return ptr.getData();
	}
	public int peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception\n");
		return front.getData();
	}
	public void display()
	{
		System.out.print("\nQueue = ");
		if(size == 0)
		{
			System.out.println("Empty\n");
			return;
		}
		Element ptr = front;
		while(ptr != back.getLink())
		{
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getLink();
		}
	System.out.println("\n");
	}
}

public class LLQueueAnkit
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		LinkedListOperations ele = new LinkedListOperations();
		//Element ele = new Element();
		//LinkedListQueue ele = new LinkedListQueue();
		System.out.println("\nLinked list queue:-");
		char ch;
		do
		{
			System.out.println("\nQueue operations:-");
            System.out.println("1. Insert a new element from the back");
            System.out.println("2. Remove an existing element from the front");
            System.out.println("3. Peek at the foremost element");
            System.out.println("4. Check if the queue is empty");
            System.out.println("5. Check the size of the queue\n");
            System.out.print("Enter your operation choice: ");
            int choice = input.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.print("\nEnter the integer value to insert: ");
                ele.insert(input.nextInt());
                break;                         
            case 2 : 
                try 
                {
                    System.out.println("\nThe element removed is " + ele.remove());
                }
                catch (Exception e)
                {
                    System.out.print("\nError : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("\nThe foremost element is " + ele.peek());
                }
                catch (Exception e)
                {
                    System.out.print("\nError : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("\nEmpty status = " + ele.isEmpty());
                break;
            case 5 : 
                System.out.println("\nThe size of the queue is " + ele.getSize());
                break;  
 
            default : 
                System.out.println("\nInvalid option, try again");
                break;
            }        
            ele.display();
            System.out.print("Do you wish to continue? (type 'y'/'Y' or 'n'/'N'): ");
            ch = input.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                                                            
    } 
}