package codetest.leetcode.algorithms.medium;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * medium
 * https://leetcode.com/problems/add-two-numbers/
 */
@Slf4j
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean hasNext = Optional.ofNullable(l1.next).isPresent() || Optional.ofNullable(l2.next).isPresent();

        int sum = Optional.ofNullable(l1).orElseGet(() -> new ListNode(0)).val + Optional.ofNullable(l2).orElseGet(() -> new ListNode(0)).val;
        int value = sum % 10;
        int div = sum / 10;

        ListNode candidate = null;

        if (hasNext) {
            ListNode l1Next = Optional.ofNullable(l1.next).orElseGet(() -> new ListNode(0));
            ListNode l2Next = Optional.ofNullable(l2.next).orElseGet(() -> new ListNode(0));
            if (div > 0) {
                l1Next.val += 1;
            }


            candidate = addTwoNumbers(l1Next, l2Next);
        } else if (div > 0)
            candidate = addTwoNumbers(new ListNode(1), new ListNode(0));

        return Optional.ofNullable(candidate).isPresent() ? new ListNode(value, candidate) : new ListNode(value);
    }

    @Test
    public void test() {
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(node1, node2);
        log.info("## Result : {}", result);

    }


    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
