package vin.LinkedList;

public class SinglyLinkedList {

	private static ListNode<Integer> head;

	public void printLinkedList(){
		ListNode<Integer> current=head;
		if(current==null)
			return; 
		while(current!=null){
			System.out.print(current.getData()+" ");
			current=current.getNext();
		}
	}

	public int lengthOfLinkedList(){
		ListNode<Integer> current=head;
		int count=0;
		if(current==null)
			return count;
		else{
			while(current!=null){
				count++;
				current=current.getNext();
			}
			return count;
		}
	}

	public ListNode<Integer> insertNodeAtEnd(int newData){
		ListNode<Integer> newNode =new ListNode<Integer>(newData);
		if(head==null){
			head=newNode;
			return head;
		}
		else{
			ListNode<Integer> current=head;
			while(current.getNext()!=null){
				current=current.getNext();
			}
			current.setNext(newNode);
			return head;
		}

	} 

	public ListNode<Integer> insertAtPosition(int newData,int position){
		if(position> lengthOfLinkedList() || position<1){
			System.out.println("Invalid position...");
			return head;
		}
		ListNode<Integer> newNode = new ListNode<Integer>(newData);
		if(position == 1){
			newNode.setNext(head);
			head=newNode;
			return head;
		}else{
			ListNode<Integer> current=head, previous=null;
			int count=1;
			while(count!=position){
				previous=current;
				current=current.getNext();
				count++;
			}
			newNode.setNext(current);
			previous.setNext(newNode);
			return head;
		}
	}

	public ListNode<Integer> insertAtBeginning(int newData){
		ListNode<Integer> newNode=new ListNode<Integer>(newData);
		if(head==null){
			head=newNode;
			return head;
		}else{
			newNode.setNext(head);
			head=newNode;			
			return head;
		}
	}

	public int searchInList(int data){
		int position=1;
		if(head==null){
			System.out.println("List does not exist...");
			return -1;
		}else{
			int check=lengthOfLinkedList();
			ListNode<Integer> current=head;
			boolean found=false;
			while(position<=check){
				if(current.getData().equals(data)){
					found=true;
					break;
				}else{
					current=current.getNext();
					position++;
				}
			}
			if(found ==true){
				System.out.println("Element "+data+" found at position "+position);
				return position;
			}else{
				System.out.println("Element "+data+" not found!");
				return -1;
			}
		}
	}

	public ListNode findMiddleNode(){
		if(head==null)
			return null;
		else{
			int pos=1;
			int check=lengthOfLinkedList()/2;
			ListNode<Integer> current=head;
			while(pos<check){
				current=current.getNext();
				pos++;
			}
			return current;

		}
	}

	public ListNode<Integer> deleteFirstNode(){
		if(head==null)
			return head;
		ListNode<Integer> deletedNode=head;
		head=head.getNext();
		deletedNode.setNext(null);
		System.out.println("Deleted First Node: "+deletedNode.getData());
		return head;
	}

	public ListNode<Integer> deleteLastNode(){
		if(head==null){
			System.out.println("List doesn't exist!");
			return head;
		}
		ListNode<Integer> current=head, previous=null;
		while(current.getNext()!=null){
			previous=current;
			current=current.getNext();
		}
		previous.setNext(null);
		System.out.println("Deleted Last Node: "+current.getData());
		return head;
	}

	public ListNode<Integer> deleteAtGivenPosition(int pos){
		if(head==null){
			System.out.println("List doesn't exist!");
			return head;
		}
		if(pos==1)
			return deleteFirstNode();
		else if(pos==lengthOfLinkedList())
			return deleteLastNode();
		else{
			int check=1;
			ListNode<Integer> current=head, previous=null;
			while(check!=pos){
				previous=current;
				current=current.getNext();
				check++;
			}
			previous.setNext(current.getNext());
			current.setNext(null);
			System.out.println("Deleted node at position "+pos+" is "+current.getData());
			return head;
		}
	}

	public ListNode<Integer> deleteGivenElementfromList(int data){
		if(head==null)
		return head;
		
		ListNode<Integer> previous=null,current=head;
		while(!current.getData().equals(data) && current.getNext()!=null){
			previous=current;
			current=current.getNext();
		}
		if(!current.getData().equals(data)){
			System.out.println("Element doesn't exist!");
			return head;
		}
		previous.setNext(current.getNext());
		current.setNext(null);
		System.out.println("Deleted given node: "+current.getData());
		return head;
	}
	public static void main(String[] args) {
		ListNode<Integer> first=new ListNode<Integer>(10);
		ListNode<Integer> second=new ListNode<Integer>(20);
		ListNode<Integer> third=new ListNode<Integer>(30);
		ListNode<Integer> fourth=new ListNode<Integer>(40);
		ListNode<Integer> fifth=new ListNode<Integer>(50);
		ListNode<Integer> sixth=new ListNode<Integer>(60);
		first.setNext(second);
		second.setNext(third);
		third.setNext(fourth);
		fourth.setNext(fifth);
		fifth.setNext(sixth);
		sixth.setNext(null);
		SinglyLinkedList linkedList=new SinglyLinkedList();
		SinglyLinkedList.head=first;
		System.out.println("After insert at Position: "+linkedList.insertNodeAtEnd(70));
		System.out.println("\nCount of List: "+linkedList.lengthOfLinkedList());
		System.out.println(linkedList.insertAtPosition(25,3));
		System.out.println(linkedList.insertAtBeginning(23));
		linkedList.searchInList(60);
		System.out.println("Middle Node: "+linkedList.findMiddleNode().getData());
		System.out.println(linkedList.deleteFirstNode());
		System.out.println(linkedList.deleteLastNode());
		System.out.println(linkedList.deleteAtGivenPosition(3));
		System.out.println(linkedList.deleteGivenElementfromList(60));
	}
}
