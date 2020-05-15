package org.leetcode.recursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {

    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
