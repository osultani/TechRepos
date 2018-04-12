package Project3;

public class LinkedList2 {
	InventoryNode head, tail;

	public LinkedList2() {
		head = null;
		tail = null;
	}

	public void insert2(int custID, int pID, int units) {
		InventoryNode node2 = new InventoryNode(custID, pID, units);
	
		if (head == null) {
			head = node2;
			tail = node2;
		} else {
			tail.setNext(node2);
			tail = node2;
		}
	}
	
	public InventoryNode find2(int custID) {
		InventoryNode current2 = head;
	
		while (current2 != null) {
			
			if (current2.getcustID2() == custID) {
				return current2;
			}
			current2 = current2.getNext();
		}
		return null;
	}
	

	public InventoryNode remove2(int custID) {
		InventoryNode current2 = head;
		while (current2 != null) {
			
			if (current2.next == null) {
				return null;
				
			} else {
				current2.setNext(current2.getNext().getNext());
			}
			
			if (current2 == head) {
				head = head.next;
			}
		}
		return current2;
	}

	
	public class InventoryNode {

		private int custID2;
		private int pID2;
		private int units2;
		InventoryNode next;

		public InventoryNode(int custID, int pID, int units) { 
			
			custID2 = custID;
			setUnits2(units);
			setpID2(pID);
			next = null;
		}

		public InventoryNode getNext() {
			return next;
		}

		public void setNext(InventoryNode n) {
			next = n;
		}

		public int getcustID2() {
			return custID2;
		}

		public void setcustID2(int p) {
			custID2 = p;
		}

		public int getpID2() {
			return pID2;
		}

		public void setpID2(int pID2) {
			this.pID2 = pID2;
		}

		public int getUnits2() {
			return units2;
		}

		public void setUnits2(int units2) {
			this.units2 = units2;
		}

		//public int getTotalUnits() {
			//return totalUnits;
		//}

		//public void setTotalUnits(int u) {
		//	totalUnits = u;
		//}

		//public int getUnitsSold() {
			//return unitsSold;
		//}

		//public void setUnitsSold(int units) {
			//unitsSold = units;
		}

		//public String toString() {
	//		return custID2 + " "  + " " +;
		}
	
