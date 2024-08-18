package Personal.Projects.Benchmark.learnDSAA;
import java.util.*;

public class learnDSAA
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("hello");

        //Stack: undo/redo, back/forward, backtrack, calling functions
        Stack<String> stack = new Stack<String>();
        System.out.println(stack.empty());
        stack.push("Pen");
        stack.push("Pencil");
        stack.push("White Out");
        stack.push("Eraser");
        String popped = stack.pop();
        System.out.println(popped);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.search("Pencil"));

        //Queues: Keyboard buffer, printer, linked lists, priority queues, breadth-first search
        Queue<String> queue = new LinkedList<String>();
        queue.offer("John");
        //queue.offer("...") .poll("...") .peek("...")
        //throws exception: add(e), remove(), element()
        //Collection class: queue.isEmpty() .size() .contains("...")

        //Priority Queue
        Queue<String> pQueue = new PriorityQueue<>();
        // Queue<Double> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        pQueue.offer("B");
        pQueue.offer("C");
        pQueue.offer("A");
        pQueue.offer("F");
        while(!pQueue.isEmpty()){System.out.println(pQueue.poll());}

        //Linked Lists: stacks/queues, gps, playlist
        LinkedList<String> linkedList = new LinkedList<String>();
        //.push adds to head, offer adds to tail
        //.pop removes from head, .poll removes from tail
        //.add(index, elt) .remove(elt) removes all with elt
        //.indexOf .peekFirst, .peekLast, 
        //.addFirst to head addLast to tail, .removeFirst, .removeLast
        System.out.println(linkedList);

        //Dynamic Array (Java = Array List, C++ = Vector, JS = Array, Python = List)
        // ArrayList<String> arrayList = new ArrayList<String>();
        dynamicArray dArray = new dynamicArray(5);
        dArray.add("A");
        dArray.add("E");
        dArray.add("G");
        dArray.add("S");
        dArray.add("W");
        dArray.add("B");
        dArray.insert(0, "X");
        dArray.delete("A");
        dArray.delete("G");
        dArray.delete("W");
        dArray.delete("X");
        System.out.println(dArray.search("A"));
        System.out.println(dArray);
        System.out.println(dArray.size);
        System.out.println(dArray.capacity);
        System.out.println(dArray.isEmpty());

        //linked lists v array lists
        //System.nanoTime(); to record time
        //array faster than linked for random element access, removing middle elements
        //linked faster than array for removing beginning elements
        //both about the same for removing elements near the end

        //big o
        //O(1) - constant time: random element access in array, inserting beginning of linked
        //O(log n) - logarithmic time: binary search
        //O(n) - linear time: loop through elts in array, search through linked
        //O(n log n) - quasilinear time: quicksort, mergesort, heapsort
        //O(n^2) - quadratic time: insertion sort, selection sort, bubble sort
        //O(n!) - traveling salesman problem

        //linear search O(n): slow for large, fast for small to medium, no need to sort, 
        //useful for ds without random access (linked list)
        int[] lArray = {6,5,3,4,1,9,8,4,2};
        int lIndex = linearSearch(lArray, 9);
        if(lIndex != -1) System.out.println(lIndex);
        else System.out.println("not found");

        //binary search O(log n): must be sorted, find target position
        //half array eliminated per "step" depends if greater or less, round down if divides evenly
        //bad with small, good with large
        int bArray[] = new int[100];
        int target = 42;
        for(int i = 0; i < bArray.length; i++){bArray[i] = i;}
        // int binaryIndex = Arrays.binarySearch(binaryIndex, target);
        int bIndex = binarySearch(bArray, target);
        if(bIndex == -1) System.out.println("not found");
        else System.out.println(bIndex);

        //interpolation search: like binary, guess value based on probe
        //average O(log(log(n))), worst O(n)
        //works well with uniformly distributed data
        int[] iArray = {1,2,3,4,5,6,7,8,9};
        int iIndex = interpolationSearch(iArray, 8);
        if (iIndex != -1) System.out.println(iIndex);
        else System.out.println("not found");

        //bubble sort O(n^2), O(1) space: compare adjacent elts
        //multiple laps, each lap largest is confirmed
        int buArray[] = {7,3,5,8,6,9,4,2,1};
        bubbleSort(buArray);
        for (int i:buArray) System.out.print(i);
        System.out.println();

        //selection sort O(n^2), O(1) space: traverse, find min, swap, continue with next index
        int sArray[] = {2,5,3,7,5,5,8,9};
        selectionSort(sArray);
        for (int i:sArray) System.out.print(i);
        System.out.println();

        //insertion sort O(n^2), O(1) space: best O(n), index 1 to temp
        //check left for larger, if so shift right, next index
        int inArray[] = {4,1,6,9,3,2,7,5};
        insertionSort(inArray);
        for (int i:inArray) System.out.print(i);
        System.out.println();

        //recursion: advanced sorts, navigating trees
        //call stack so can stack overflow
        System.out.println(power(2,8));

        //merge sort O(n log n) time, O(n) space: divide & conquer
        int[] mArray = {6,3,1,7,5,4,9,8,2};
        mergeSort(mArray);
        for(int i = 0; i < mArray.length; i++) System.out.print(mArray[i] + " ");

        //quicksort O(nlog(n)), O(log n) space: pivot (usually end), swap values around pivot
        //best & average O(nlog(n)), worst O(n^2) if already sorted, O(log n) space
        //elts to left of piv less than, greater than or equal to the right
        //repeat with new pivot for left and right
        int[] qArray = {6,4,2,1,7,3,8,9,5};
        quickSort(qArray, 0, qArray.length - 1);
        for(int i : qArray) System.out.print(i + " ");
        System.out.println("\n");

        //hash tables: entry<K,V>, key.hashCode() % capacity
        //123, "John" -> 123 % 10 (index 0 - 9) = 3 inserted at index 3
        //Integer hash -> x, String hash -> s[0]*31^(n-1)+s[1]*31^(n-2)+...+s[n-1]
        //different data types have different hash code formulas
        //collision: if 123 is a string, hash is 48690, % 10 = index 0
        //if 321 -> 50610 = index 0 as well, then most common solution is to
        //turn each bucket (ex. index 0) into a linked list so at index 0 123 -> 321 -> ...
        //aka chaining, less collision = more efficient, ideally want each entry with own bucket
        //need to find best hash code for least collision for each entry list
        Hashtable<String, String> table = new Hashtable<>(21);
        //initial capacity (11) and load factor (0.75), but can change Hashtable<>(10, 0.5f);
        table.put("100", "John");
        table.put("123", "James");
        table.put("321", "Jake");
        table.put("555", "Jack");
        // table.remove(321);
        for(String key : table.keySet()) 
            System.out.println(key + "\t" + key.hashCode() + "\t" + key.hashCode() % 21 + "\t" + table.get(key));
        //increase hash table size to avoid collisions, Hashtable<>(21), key.hashCode() % 21
        //fash insertion,search,deletion, bad for small data sets, great with large data sets
        //runtime complexity: best O(1) with no collisions, worst O(n) all collisions so linked list
        System.out.println();
        
        //graphs: node (vertex), edge. undirected (social network), directed (street map). adjacency (connection)
        //adjacency matrix (time O(1), space O(V^2)) and list (time O(V), space(O(V+E))

        //matrix
        graph mGraph = new graph(5);
        mGraph.addNode(new node('A')); //0
        mGraph.addNode(new node('B')); //1
        mGraph.addNode(new node('C')); //2
        mGraph.addNode(new node('D')); //3
        mGraph.addNode(new node('E')); //4
        mGraph.addEdge(0, 1);
        mGraph.addEdge(1, 2);
        mGraph.addEdge(2, 3);
        mGraph.addEdge(2, 4);
        mGraph.addEdge(4, 0);
        mGraph.addEdge(4, 2);
        mGraph.print();
        System.out.println(mGraph.checkEdge(2, 4));
        System.out.println();

        //list
        graph2 lGraph = new graph2();
        lGraph.addNode(new node('A'));
        lGraph.addNode(new node('B'));
        lGraph.addNode(new node('C'));
        lGraph.addNode(new node('D'));
        lGraph.addNode(new node('E'));
        lGraph.addEdge(0, 1);
        lGraph.addEdge(1, 2);
        lGraph.addEdge(1, 4);
        lGraph.addEdge(2, 3);
        lGraph.addEdge(2, 4);
        lGraph.addEdge(4, 0);
        lGraph.addEdge(4, 2);
        lGraph.print();
        System.out.println();

        //depth first search (tree/graph): one branch at a time
        //pick route until dead end / visited, backtrack to last node with unvisited neighbors
        //for picking routes stick to one
        //dfs can use stack, push for new node, pop and backtrack when node visited
        //best if dest far from start, children visited before siblings, more popular for games/puzzles
        mGraph.depthFirstSearch(4);
        System.out.println();

        //breadth first search: one level at a time, bfs can use queue
        //best if dest is close to start on avg, siblings visited before children
        graph3 mGraph2 = new graph3(5);
        mGraph2.addNode(new node('A')); //0
        mGraph2.addNode(new node('B')); //1
        mGraph2.addNode(new node('C')); //2
        mGraph2.addNode(new node('D')); //3
        mGraph2.addNode(new node('E')); //4
        mGraph2.addEdge(0, 1);
        mGraph2.addEdge(1, 2);
        mGraph2.addEdge(2, 3);
        mGraph2.addEdge(2, 4);
        mGraph2.addEdge(4, 0);
        mGraph2.addEdge(4, 2);
        mGraph2.print();
        mGraph2.breadthFirstSearch(4);
        System.out.println();

        //tree: file explorer, databases, dns, html dom

        //binary tree: no more than two children
        //binary search tree: root greater than left, less than right (= quick lookup)
        //O(log n) time at best, O(n) worst, O(n) space
        binarySearchTree tree = new binarySearchTree();
        tree.insert(new node2(5));
        tree.insert(new node2(1));
        tree.insert(new node2(9));
        tree.insert(new node2(2));
        tree.insert(new node2(7));
        tree.insert(new node2(3));
        tree.insert(new node2(6));
        tree.insert(new node2(4));
        tree.insert(new node2(8));
        // System.out.println(tree.search(4));
        // tree.remove(0);
        tree.remove(4);
        tree.display();

        //tree traversal
        //in-order: left->root->right
        /*
         * traverseTree(root)
         *  traverseTree(root.left)
         *  System.out.println(root.data)
         *  traverseTree(root.right)
         */
        //post-order: left->right->root
        /*
         * traverseTree(root)
         *  traverseTree(root.left)
         *  traverseTree(root.right)
         *  System.out.println(root.data)
         */
        //pre-order: left
        /*
         * traverseTree(root)
         *  System.out.println(root.data)
         *  traverseTree(root.left)
         *  traverseTree(root.right)
         */

         //runtime
         long start = System.nanoTime();
         Thread.sleep(3000);
         long duration = (System.nanoTime() - start) / 1000000;
         System.out.println(duration + " ms");
    }

    private static void quickSort(int[] array, int start, int end)
    {
        if(end <= start) return;
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }
    private static int partition(int[] array, int start, int end)
    {
        int pivot = array[end];
        int i = start - 1;
        for(int j = start; j <= end - 1; j++)
        {
            if(array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    private static void mergeSort(int[] array)
    {
        int length = array.length;
        if(length <= 1) return;
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0;
        int j = 0;
        for(; i < length; i++)
        {
            if(i < middle)
            {
                leftArray[i] = array[i];
            }
            else
            {
                rightArray[j] = array[i];
                j++;
            }    
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    private static void merge(int[] leftArray, int[] rightArray, int[] array)
    {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;
        while(l < leftSize && r < rightSize)
        {
            if(leftArray[l] < rightArray[r])
            {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize)
        {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize)
        {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    private static int power(int base, int exponent)
    {
        if(exponent < 1) return 1;
        return base * power(base, exponent - 1);
    }

    private static void insertionSort(int[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
            int temp = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > temp)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
    private static void selectionSort(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            int min = i;
            for(int j = i + 1; j < array.length; j++)
            {
                if(array[min] > array[j]) min = j;
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
    public static void bubbleSort(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            for(int j = 0; j < array.length - i - 1; j++)
            {
                if(array[j] > array[j+1]) //for decending <
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    private static int interpolationSearch(int[] array, int value)
    {
        int high = array.length - 1;
        int low = 0;
        while(value >= array[low] && value <= array[high] && low <= high)
        {
            int probe = low + (high - low) * (value - array[low]) / (array[high] - array[low]);
            System.out.println(probe);
            if(array[probe] == value) return probe;
            else if (array[probe] < value) low = probe + 1;
            else high = probe - 1;
        }
        return -1;
    }
    private static int binarySearch(int[] array, int target)
    {
        int low = 0;
        int high = array.length - 1;
        while(low <= high)
        {
            int middle = low + (high - low) / 2;
            int value = array[middle];
            // System.out.println(value);
            if(value < target) low = middle + 1;
            else if(value > target) high = middle - 1;
            else return middle;
        }
        return -1;
    }
    private static int linearSearch(int[] array, int value)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] == value) return i;
        }
        return -1;
    }
}
