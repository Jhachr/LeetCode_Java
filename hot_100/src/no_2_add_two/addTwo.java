package no_2_add_two;

import Domain.ListNode;

import java.util.Objects;

public class addTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(-1);
        ListNode now = startNode;
        int flag = 0;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            ListNode newNode = new ListNode();
            int sum = l1.val + l2.val + flag;
            newNode.val = sum % 10;
            flag = sum / 10;
            now.next = newNode;
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (Objects.isNull(l1) && Objects.isNull(l2)){
            if (flag == 1){
                now.next = new ListNode(1);
            }
            return startNode.next;
        }

        now.next = Objects.nonNull(l1) ? addTwoNumbers(l1,new ListNode(flag)) : addTwoNumbers(l2 , new ListNode(flag));

        return startNode.next;
    }
}
