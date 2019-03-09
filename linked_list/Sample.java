public class Sample{
    
    public static void main(String[] args){
        
        LinkList list = new LinkList();

        System.out.println("===== Append =====");
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append("five");
        list.append(6);
        list.append("five");
        list.append(3);
        list.show();

        System.out.println("===== deleteDups =====");
        list.deleteDups();
        list.show();

        System.out.println("===== findLastNth =====");
        int index = 3;
        Cell del = list.findLastNth(index);
        System.out.println("The Node(-" + index + ") is " + del.data);

        System.out.println("===== deleteNode =====");
        list.deleteNode(del);
        list.show();

        System.out.println("===== listAdder =====");
        int[] arr1 = {5, 2, 6};
        int[] arr2 = {8, 9, 4, 9, 1};
        LinkList l1 = new LinkList(arr1);
        LinkList l2 = new LinkList(arr2);
        l1.show();
        l2.show();

        LinkList.listAdder(l1, l2).show();

        System.out.println("===== isPalindrome =====");
        int[] arr3 = {1, 2, 3, 4, 3, 2, 1};
        int[] arr4 = {1, 2, 3, 4, 4, 2, 1};
        LinkList l3 = new LinkList(arr3);
        LinkList l4 = new LinkList(arr4);
        l3.show();
        System.out.println(l3.isPalindrome());
        l4.show();
        System.out.println(l4.isPalindrome());
        
        System.out.println("===== isBranch =====");
        int[] arr5 = {3, 1, 5, 9, 7, 2, 1};
        int[] arr6 = {4, 6};
        LinkList l5 = new LinkList(arr5);
        LinkList l6 = new LinkList(arr6);
        // to make branched list
        l6.head.next.next.next = l5.head.next.next.next.next.next;
        l5.show();
        l6.show();

        System.out.println(LinkList.isBranch(l5, l6));

        System.out.println("===== findRing =====");
        int[] arr7 = {1, 2, 3, 4, 5, 6};
        LinkList l7 = new LinkList(arr7);
        System.out.println("Head -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 -> 4 -> ...");
        // to make ring list
        l7.head.next.next.next.next.next.next.next = l7.head.next.next.next;
        l7.findRing();
    }
}
