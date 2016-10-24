package ro.siit.j4;

import java.util.LinkedList;

public class FestivalGate {
	
	LinkedList<TicketType> queue = new LinkedList<>();
	
	public void add(TicketType ticket){
		queue.add(ticket);
	}
	
	public boolean isEmpty(){
		return queue.isEmpty();
	}
	
	public int getLength(){
		return queue.size();
	}
	
	public TicketType removeFirst(){
		return queue.removeFirst();
	}
	
	
}
