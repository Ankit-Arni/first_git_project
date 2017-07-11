import java.util.*;

class Element
{
	private int data;
	private Element link;
	public Element()
	{
		link = NULL;
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
	public void getData()
	{
		return this.data;
	}
	public void getLink()
	{
		return this.link;
	}	
}

class LinkedListOperations
{
	private Element front, back;
	public int size;
	public LinkedListOperations()
	{
		front = NULL;
		back = NULL;
		size = 0;
	}
	public boolean isEmpty()
	{
		return front == NULL;
	}
	public int getSize()
	{
		return size;
	}
	public void insert(int data)
	{
		Element ptr = new Element(data, NULL);
		if(back == NULL)
		{
			front = ptr;
			back = ptr;
		}
		else
		{
			back.setLink(ptr);
			back = getLink();
		}
		size++;
	}
	public int remove()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		Element ptr = front;
		front = ptr.getLink();
		if(front == NULL)
			back = NULL;
		size--;
		return ptr.getData();
	}
	public int peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow exception");
		return front.getData();
	}
	public void display()
	{
		System.out.println("\nQueue = ");
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
	System.out.println();
	}
}

public class LinkedListQueue
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		LinkedListQueue lq = new LinkedListQueue();
		System.out.println("Linked list queue:-\n");
		char ch;
		do
		{
			System.out.println("\nQueue operations:-");
            System.out.println("1. Insert");
            System.out.println("2. Remove");
            System.out.println("3. Peek");
            System.out.println("4. Check if empty");
            System.out.println("5. Size");
            int choice = input.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                lq.insert(input.nextInt());
                break;                         
            case 2 : 
                try 
                {
                    System.out.println("Removed Element = "+ lq.remove());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }    
                break;                         
            case 3 : 
                try
                {
                    System.out.println("Peek Element = "+ lq.peek());
                }
                catch (Exception e)
                {
                    System.out.println("Error : " + e.getMessage());
                }
                break;                         
            case 4 : 
                System.out.println("Empty status = "+ lq.isEmpty());
                break;
            case 5 : 
                System.out.println("Size = "+ lq.getSize());
                break;  
 
            default : 
                System.out.println("Wrong Entry\n ");
                break;
            }        
            lq.display();
            System.out.println("\nDo you want to continue? (type y or n) \n");
            ch = input.next().charAt(0);            
        } while (ch == 'Y'|| ch == 'y');                                                            
    } 
}