import java.util.*;

/**
 * This class describes a priority min-queue that uses an array-list-based min binary heap 
 * that implements the PQueueAPI interface. The array list holds objects that implement 
 * the parameterized Comparable interface.
 * @author Duncan, Quentin
 * <pre>
 * Date: LAST DATE MODIFIED TODO
 * course: csc 3102
 * Programming Project: 1
 * Instructor: Dr. Duncan
 *
 * DO NOT REMOVE THIS NOTICE (GNU GPL V2):
 * Contact Information: duncanw@lsu.edu
 * Copyright (c) 2026 William E. Duncan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/> 
 * <pre>
 */
 
 
 /**
  * A min-priority queue implementation that uses an 
  * array list as its data container
  * @param <E> the priority queue element type.   
  */
public class PQueue<E extends Comparable<E>> implements PQueueAPI<E>
{    
   /**
    * A complete tree stored in an array list representing the 
    * binary heap
    */
   private ArrayList<E> tree;
   /**
    * A comparator lambda function that compares two elements of this
    * heap when rebuilding it; cmp.compare(x,y) gives 1. negative when x less than y
    * 2. positive when x greater than y 3. 0 when x equal y
    */   
   private Comparator<? super E> cmp;
   
   /**
    * Constructs an empty PQueue using the compareTo method of its data type as the 
	* comparator
    */
   public PQueue()
   {
     this.tree = new ArrayList<E>();
   }
   
   /**
    * copy constructor
    */
   public PQueue(PQueue pQ)
   {
     this.cmp = pQ.cmp;
     this.tree = pQ.tree;
   }
   
   /**
    * A parameterized constructor that uses an externally defined comparator    
    * @param fn - a trichotomous integer value comparator function   
    */
   public PQueue(Comparator<? super E> fn)
   {
     this();
     this.cmp = fn;
   }

   public boolean isEmpty()
   {
     return (this.size() == 0) ? true: false;
   }

   public void add(E obj)
   {
     try {
       this.tree.add(obj);
       heapifyUp(this.size()-1);
     } catch (Error error) {
       System.out.println(error);
     }
   }

   public E remove() throws PQueueException
   {
     return this.tree.removeFirst();
   }
 
   public E peek() throws PQueueException
   {
     return this.tree.get(0);
   }

   public int size()
   {
     return tree.size();
   }
   
   /**
    * Swaps a parent and child elements of this heap at the specified indices
    * @param place an index of the child element on this heap
    * @param parent an index of the parent element on this heap
    */
   private void swap(int place, int parent)
   {
     var tmp = this.tree.get(place);
     this.tree.set(place, this.tree.get(parent));
     this.tree.set(parent, tmp);
   }

    /**
     * Rebuild this priority queue from the 
     * specified index using a trickle up procedure
     * @param index the index at which to begin the rebuild
     */
    private void heapifyUp(int index)
    {
      int parent = 2*(index+1);
      while (index > 0 && cmp.compare(this.tree.get(index), this.tree.get(parent)) >= 1) 
      {
        this.swap(index, parent);
        index = parent;
        parent = 2*(index+1);
      }
    }
    
    /**
     * Rebuild this priority queue from the 
     * specified index using a trickle down procedure
     * @param index the index at which to begin the rebuild
     */   
    public void heapifyDown(int index)
    {
      int size = this.size();
      int parent = index;
      int child = 2*(parent+1);
    }
}
