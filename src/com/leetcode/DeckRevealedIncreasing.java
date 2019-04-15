package com.leetcode;

import java.util.ArrayList;
import java.util.List;


public class DeckRevealedIncreasing {

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result;
        insertion(deck);

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<deck.length; i++) {
            if(i%2==0)
                list.add(deck[i]);
            else
                list.add(deck[i]);
        }

        return deck;
    }

    public static void insertion(int[] orgin) {

        for(int i=1; i<orgin.length; i++) {
            int v = orgin[i];
            int j = i-1;
            while (j>=0 && orgin[j]>v) {
                orgin[j+1] = orgin[j];
                j--;
            }
            orgin[j+1] = v;
        }
    }
}
