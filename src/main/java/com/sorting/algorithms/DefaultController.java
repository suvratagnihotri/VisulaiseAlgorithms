package com.sorting.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    @Autowired
    AlgorithmService algorithmService;
    ModelMap model;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value="/home", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String array,@RequestParam String algo){
        this.model = model;

        if (array.length()<2) {
            this.model.addAttribute("errorMessage", "Array Length should be more than 2");
            return "home";
        }
        if(!array.contains(",")){
            this.model.addAttribute("errorMessage", "Array shoul contain at least 2 integer values");
            return "home";
        }
        if(algorithmService.checkValidArray(array) == false){
            this.model.addAttribute("errorMessage", "Array should contain only comma separated Integer Values.");
        }

        this.model.put("name", array);
        int [] unSortedArray = algorithmService.getArray();
        this.model.put("array", Arrays.toString(unSortedArray));
        this.model.put("algo", algo);

        ArrayList<ArrayList<Integer>> sortedArray = new ArrayList<>();
        if(algo.equals("selection-sort")){
            sortedArray = algorithmService.selectionSort(unSortedArray);
        }
        else if(algo.equals("bubble-sort")){
            sortedArray = algorithmService.bubbleSort(unSortedArray);
        }
        else if(algo.equals("insertion-sort")){
            sortedArray = algorithmService.insertionSort(unSortedArray);
        }

        this.model.put("sortedArray", sortedArray);

        return "welcome";
    }
}
