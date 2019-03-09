import java.util.*;

public class LinkList{
   
    Cell head;
    Cell tail;

    LinkList(){
        this.head = new Cell("Head");
        this.tail = new Cell("Tail");
        this.head.next = tail;
    }

    LinkList(int[] arr){
        this.head = new Cell("Head");
        this.tail = new Cell("Tail");
        this.head.next = tail;
        appendArray(arr);
    }



    public String toString(){
        StringBuilder str = new StringBuilder();
        Cell p = this.head;


        while(p.next != null){
            str.append(p.data + " -> ");
            p = p.next;
        }
        str.append("Tail");

        return str.toString();
    }

    public void show(){
        System.out.println(toString());
    }

    public int length(){
        int len = 1;
        Cell n = this.head;

        while(n.next != null){
            n = n.next;
            len++;
        }

        return len;
    }

    public void append(Object data){
        
        Cell tail = this.head.next;
        Cell prev_tail = this.head;
        Cell cell = new Cell(data);

        while(tail.next != null){
            tail = tail.next;
            prev_tail = prev_tail.next;
        }

        prev_tail.next = cell;
        cell.next = tail;
    }

    public void appendArray(int[] arr){
        for(int i=0; i<arr.length; i++) append(arr[i]);
    }

    
    public void deleteDups(){
        
        HashSet<Object> set = new HashSet<Object>();
        
        Cell now = this.head;
        Cell prev = null;

        for(now = this.head; now.next != null; now = now.next){
            if(set.contains(now.data)){
                prev.next = now.next;
            }
            else{
                set.add(now.data);
                prev = now;
            }
        }
    }

    public Cell findLastNth(int k){
        
        Cell c1 = this.head;
        Cell c2 = this.head;

        for(int i=0; i<k; i++){
            if(c1.next == null) return null;
            c1 = c1.next;
        }

        while(c1.next != null){
            c1 = c1.next;
            c2 = c2.next;
        }

        return c2;
    }

    // delete certain node without head
    public void deleteNode(Cell node){
        
        if(node.next == null){
            System.out.println("deleteNode: Failure");
            return;
        }

        Cell next = node.next;

        node.data = next.data;
        node.next = next.next;
    }


    public static LinkList listAdder(LinkList link1, LinkList link2){
        
        LinkList result = new LinkList();

        int val = 0;
        int carry = 0;

        Cell l1 = link1.head.next;
        Cell l2 = link2.head.next;

        try{
            while(!(l1.next==null && l2.next==null)){
                
                val = carry;
                
                if(l1.next != null){
                    val += (int)l1.data;
                    l1 = l1.next;
                }
                if(l2.next != null){
                    val += (int)l2.data;
                    l2 = l2.next;
                }

                result.append(val % 10);
                carry = val / 10; 
            }

            if(carry != 0) result.append(carry);
        }
        catch(ClassCastException e){
            System.out.println(e);
        }
        
        return result;
    }

    // judge palindrome except head and tail
    public boolean isPalindrome(){
        int len = this.length();

        // len = 2 means this list has only head and tail
        if(len <= 3) return true;

        len /= 2;
        Cell former = this.head.next; 
        Cell latter;
        for(int i=1; i<len; i++){
            latter = findLastNth(i);
            if(former.data != latter.data) return false;
            former = former.next;
        }

        return true;
    }


    public static boolean isBranch (LinkList link1, LinkList link2){
        
        int len1 = link1.length();
        int len2 = link2.length();

        Cell l1 = link1.head;
        Cell l2 = link2.head;

        // go to tail
        while(l1.next != null) l1 = l1.next;
        while(l2.next != null) l2 = l2.next;

        // check if both link1 and link2 have same tail
        if(l1 != l2) return false;

        // assume l1 >= l2
        l1 = (len1 >= len2) ? link1.head : link2.head;
        l2 = (len1 <  len2) ? link1.head : link2.head;

        // align l1 and l2 length
        int diff = Math.abs(len1 - len2);
        for(int i=0; i<diff; i++) l1 = l1.next;

        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }

        System.out.println("The common data is " + l1.data + ", " + l2.data);

        return true;
    }

    public void findRing(){
        
        Cell slow = this.head;
        Cell fast = this.head;

        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }
        if(fast.next.next == null || fast.next == null){
            System.out.println("This list does not have ring structure");
            return;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("The beginning of ring is " + fast.data + ", " + slow.data);
        return;
    }
}
