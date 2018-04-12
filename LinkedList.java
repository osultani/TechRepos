package Project3;

public class LinkedList {
	InventoryNode head, tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public void insert(int id, int units) {
		InventoryNode node = new InventoryNode(id, units);
	
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
	}
	
	public InventoryNode find(int id) {
		InventoryNode current = head;
	
		while (current != null) {
			
			if (current.getProdID() == id) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	

	public InventoryNode remove(int id) {
		InventoryNode current = head;
		while (current != null) {
			
			if (current.next == null) {
				return null;
				
			} else {
				current.setNext(current.getNext().getNext());
			}
			
			if (current == head) {
				head = head.next;
			}
		}
		return current;
	}

	
	public class InventoryNode {

		private int ProdID;
		private int totalUnits;
		private int unitsSold;
		InventoryNode next;

		public InventoryNode(int id, int units) { 
			
			ProdID = id;
			totalUnits = units;
			unitsSold = 0;
			next = null;
		}

		public InventoryNode getNext() {
			return next;
		}

		public void setNext(InventoryNode n) {
			next = n;
		}

		public int getProdID() {
			return ProdID;
		}

		public void setProdID(int p) {
			ProdID = p;
		}

		public int getTotalUnits() {
			return totalUnits;
		}

		public void setTotalUnits(int u) {
			totalUnits = u;
		}

		public int getUnitsSold() {
			return unitsSold;
		}

		public void setUnitsSold(int units) {
			unitsSold = units;
		}

		public String toString() {
			return ProdID + " " + totalUnits + " " + unitsSold;
		}
		
		
		
	}
}
