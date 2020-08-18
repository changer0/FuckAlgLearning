package com.lulu.leetcode.二叉树._109_有序链表转换二叉搜索树;

import com.lulu.leetcode.二叉树.TreeNode;
import com.lulu.leetcode.链表.java.ListNode;

/**
 *
 */
class Solution {


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    }
    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode mid = getMidNode(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    /**
     * 链表中间位置获取方式
     * @param left
     * @param right
     * @return
     */
    private ListNode getMidNode(ListNode left, ListNode right) {
        //一个走两步的，一个走一步的
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
