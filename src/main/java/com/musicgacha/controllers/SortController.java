package com.social_credit_farming.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class SortController {
    @GetMapping("/data/scoresort")
    public String scoresort(){
        return "homesite/scoresort";
    }

    @GetMapping("/cb/sort")
    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String insert(
            @RequestParam(name = "array", required = false, defaultValue = "1 2 3 4 5 6") String array,
            @RequestParam(name = "selection", required = false, defaultValue = "") String selection,
            Model model) {
        // @RequestParam handles required and default values, name and model are class variables, model looking like JSON

        int[] arr = method(array);
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        long startTime = System.nanoTime();

        if (selection.equals("selectsort") ){

            int n = arr.length;
            // One by one move boundary of unsorted subarray
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (arr[j] < arr[min_idx])
                        min_idx = j;

                // Swap the found minimum element with the first
                // element
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
            for (int i = 0; i < n; ++i)
                sorted.add(arr[i]);

        }
        if (selection.equals("insertsort")) {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
            for (int i = 0; i < n; ++i)
                sorted.add(arr[i]);
        }
        if (selection.equals("mergesort")){

        }
        StringBuilder sb = new StringBuilder();
        for (Integer sort : sorted) {
            sb.append(sort);
            sb.append(", ");
        }
        long endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime);

        String time = String.valueOf(timeElapsed);

        String intlist = sb.toString();

        model.addAttribute("intlist", intlist); // MODEL is passed to html
        model.addAttribute("time", time); // MODEL is passed to html


        return "minilabs/sort"; // returns HTML VIEW (greeting)
    }

    private int[] method(String replace) {
        String[] splitArray = replace.split(" ");
        int[] array = new int[splitArray.length];

        // parsing the String argument as a signed decimal
        // integer object and storing that integer into the
        // array
        for (int i = 0; i < splitArray.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }
        return array;
    }
}
