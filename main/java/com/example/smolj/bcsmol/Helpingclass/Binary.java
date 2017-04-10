package com.example.smolj.bcsmol.Helpingclass;

        import com.example.smolj.bcsmol.files.*;
        import com.example.smolj.bcsmol.Graf.*;
        import java.util.ArrayList;

/**
 *
 * @author SmolJ
 */
public class Binary {

    int[] data;
    int size;
    Graph g = new Graph();
    Spoje s;

    public Spoje findSpoj(Hrana h, int time) {

        int low = 0;
        int high = h.getArrayS().size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (h.getArrayS().get(middle).getDepartureTime() == time
                    || (h.getArrayS().get(middle).getDepartureTime() > time
                    && (middle-1 >=0 && h.getArrayS().get(middle - 1).getDepartureTime() < time))) {
                s = (h.getArrayS().get(middle));
                return s;

            }
            if (h.getArrayS().get(middle).getDepartureTime() < time) {
                low = middle + 1;
            }
            if (h.getArrayS().get(middle).getDepartureTime() > time) {
                high = middle - 1;
            }
        }

        return s;
    }

}

// int[] data;
//2    int size;
//3
//4    public boolean binarySearch(int key)
//5    {
//6         int low = 0;
//7         int high = size - 1;
//8
//9         while(high >= low) {
//10             int middle = (low + high) / 2;
//11             if(data[middle] == key) {
//12                 return true;
//13             }
//14             if(data[middle] < key) {
//15                 low = middle + 1;
//16             }
//17             if(data[middle] > key) {
//18                 high = middle - 1;
//19             }
//20        }
//21        return false;
//22   }
