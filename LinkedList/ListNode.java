package vin.LinkedList;
class ListNode<T>{
		private T data;
		private ListNode next;
		
		public ListNode(T data) {
			this.data=data;
		}
		
		public void setData(T data) {
			this.data = data;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
		public T getData() {
			return data;
		}
		public ListNode getNext() {
			return next;
		}
		@Override
		public String toString() {
			return "Node: "+this.data+" next-> "+this.next;
		}
	}
