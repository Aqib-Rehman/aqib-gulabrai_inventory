package project;
/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * Company:      Bell Labs, Soft Solutions [The End of Logic]
 * @author Mr. sachal Joyo , Jay Kumar
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class MyOwnFocusTraversalPolicy //extends FocusTraversalPolicy
    {
        Vector order; // Vector<Component>
                                    // Vector<Component>
        public MyOwnFocusTraversalPolicy(Vector order) {
            this.order = new Vector(order.size());
            this.order.addAll(order);
        }
        public Component getComponentAfter(Container focusCycleRoot,
                                           Component aComponent)
        {
            int idx = (order.indexOf(aComponent) + 1) % order.size();
            System.out.println("getComponent after");
            return (Component)order.get(idx);
        }

        public Component getComponentBefore(Container focusCycleRoot, Component aComponent)
        {
            int idx = order.indexOf(aComponent) - 1;
            System.out.println("getComponent before");
            if (idx < 0) {
                idx = order.size() - 1;
            }
            return (Component)order.get(idx);
        }

        public Component getDefaultComponent(Container focusCycleRoot) {
            System.out.println("getDefaultComponent");
            return (Component)order.get(0);
        }

        public Component getLastComponent(Container focusCycleRoot) {
            return (Component)order.lastElement();
        }

        public Component getFirstComponent(Container focusCycleRoot) {
            return (Component)order.get(0);
        }
}