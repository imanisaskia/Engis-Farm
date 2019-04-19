package player;

import java.util.LinkedList;

public class Bag<E>{
    private static final int MAX_BAG = 7;
	private LinkedList<E> belongings;
	
	public Bag(){ /*constructor*/
		belongings = new LinkedList<E>();
	}

	/*getter size*/
	public int getSize(){
		return belongings.size();
	}

	/* return elements's index, -1 if not found*/
	public int find(E element){
		return belongings.indexOf(element);
	}
	
	/* return True if Bag empty*/
	public boolean isEmpty(){
		if(belongings.size()==0){
			return true;
		}else{
			return false;
		}
	}

	/* add value as the last member of Bag*/
	public void add(E element){
		if(belongings.size() != MAX_BAG){
			belongings.addLast(element);
		}
	}

	/* remove element from Bag*/
	public void remove(E element){
		belongings.remove(element);
	}
	
	/* return a member of Bag on index*/
    public E getBelonging(int index){
		 return belongings.get(index);
	}	
}

