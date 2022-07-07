package no_2_add_two;

import Domain.ListNode;

import java.util.Objects;

public class addTwo {

    /*
        这里主要使用了递归的办法，发现这里其实分三种情况，
        1.当两个节点都还在，则按照进位+
        2.当两个节点都为NUll，如果进位为0，则直接返回，如果进位为1，则新建一个为1的node
        3.当其中一个节点为null时，其实处理的逻辑是 用不为空的节点跟一个值为flag的node进行第一种处理，这里其实是一种递归。
        完成！
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = new ListNode(-1);
        ListNode now = startNode;
        int flag = 0;
        if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
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

    /*
        对比方法1 这种方法其实抽象程度更高些
        其实方法1中说的情况1跟情况3是同一种情况，无非情况3对应了
        一个数字为0的节点跟另外一个正常节点相加，写法上更加优雅一些。

     */
    public ListNode addTwoNumbersMethod2(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode now = pre;
        int carry = 0 ;
        while (l1!=null || l2!= null){
            ListNode newNode = new ListNode();
            int l1Val = Objects.nonNull(l1) ? l1.val : 0;
            int l2Val = Objects.nonNull(l2) ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            newNode.val  = sum%10;
            carry = sum/10;
            now.next = newNode;
            if (Objects.nonNull(l1)){
                l1 = l1.next;
            }
            if (Objects.nonNull(l2)){
                l2 = l2.next;
            }
        }
        if (carry == 1){
            now.next = new ListNode(1);
        }
        return pre.next;
    }


    public ListNode addTwoNumbersMethod3(ListNode l1, ListNode l2 ,int flag ) {
        ListNode newNode = new ListNode();
        if (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            int l1val = Objects.nonNull(l1) ? l1.val : 0 ;
            int l2val = Objects.nonNull(l2) ? l2.val : 0 ;
            int sum = l1val + l2val + flag;
            newNode.val = sum % 10;
            flag = sum / 10;
            addTwoNumbersMethod3(Objects.nonNull(l1) ? l1.next : null ,Objects.nonNull(l2) ? l2.next : null,flag);
        }
        if (Objects.isNull(l1) && Objects.isNull(l2)){
            if (flag == 1){
                newNode = new ListNode(1);
            }
            return newNode;
        }


        return newNode;
    }

}
