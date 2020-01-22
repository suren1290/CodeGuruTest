package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class IntersectingLinkedLists {
    public IntersectingLinkedLists() {
    }

    public Stack<Integer> solution(LinkedList<Integer> p1, LinkedList<Integer> p2) {
        Stack mystack = new Stack();
        Iterator var4 = p1.iterator();

        while (var4.hasNext()) {
            int i = ((Integer) var4.next()).intValue();
            if (p2.contains(Integer.valueOf(i))) {
                mystack.push(Integer.valueOf(i));
            }
        }

        return mystack;
    }
}

