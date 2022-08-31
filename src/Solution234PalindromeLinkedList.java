import java.util.ArrayList;

public class Solution234PalindromeLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //first try, convert link list to array List and traverse
  //it is not necessary find the last node of link list
  static boolean isPalindrome(ListNode head) {
        // to array
        ArrayList<Integer> intList = new ArrayList();
        ListNode nowNode = head;
        intList.add(nowNode.val);
        while(nowNode.next!=null){
            nowNode = nowNode.next;
            intList.add(nowNode.val);
        }

        int i=0;
        int j=intList.size()-1;
        while(i<j){
            if(!intList.get(i).equals(intList.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    static boolean isPalindrome(ListNode head){
//
//    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next=node2; node2.next=node3;node3.next=node4;
        System.out.println(isPalindrome(node1));
    }
}
