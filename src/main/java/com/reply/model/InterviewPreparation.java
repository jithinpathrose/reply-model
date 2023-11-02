package com.reply.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class InterviewPreparation {

    public int solution(int[] A) {
        AtomicInteger result = new AtomicInteger(1);
        boolean isFound = false;

        isFound = Arrays.stream(A).anyMatch(a -> a> result.get());

        if(!isFound){

            return result.get();

        }else{


            Arrays.stream(A).sorted().forEach(a-> {

                if(a == result.get() +1){

                    result.set(a);
                }
            });

            return result.get() +1;
        }

    }

    public int solution(int[] A, int[] B) {
        int k = 0;
        boolean isFound = false;

        if(A.length == B.length){

            for(k=1; k< A.length-1; k++){

                int ASum = Arrays.stream(A, 0 , k+1).sum();
                int BSum = Arrays.stream(B, 0, k+1).sum();

                if(ASum == BSum){

                    int ARemainingSum = Arrays.stream(A, k+1, A.length).sum();
                    int BRemainingSum = Arrays.stream(B, k+1, B.length).sum();

                    if(ARemainingSum == BRemainingSum && ARemainingSum == ASum){
                        isFound = true;
                        break;
                    }
                }
            }

        }

        return !isFound?0:k;
    }


    public static void main(String[] args){

        int[] A = {1, 4, 2, -2, 5};
        int[] B = {7, -2, -2, 2, 5};
        InterviewPreparation interviewPreparation =new InterviewPreparation();
        interviewPreparation.solution(A,B);

        String usecase = "5";



        int e = A.length;

        switch(usecase){

            case "1" : findCommon(); break;
            
            case "2" : findLongestWord(); break;

            case "3": findFactorial(); break;

            case "4" : findPalindrom();break;

            case "5" : binaryTree();break;
        }

    }

    private static void binaryTree() {

        String[] s =new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"};
        /*
         * 1. A parent should have 2 children
         * 2. There shouldn't be more than 1 root node
         * */
        // code goes here
        for(String node : s){
            String[] parts = node.split(",");
            String child = parts[0].replaceAll("[() ]", "");
            String parent = parts[1].replaceAll("[() ]", "");



        }

    }

    private static void findPalindrom() {

        String s = "never odd or even".trim();

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuffer stringBuffer = new StringBuffer(s);

        System.out.println(stringBuffer.reverse().toString());

        int left = 0;
        int right = s.length()-1;

        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                System.out.println( "false");
            }
            left ++;
            right --;
        }
    }

    private static void findFactorial() {
        int num= 5;
        int factorial = 1;

        for(int i=num; i>0; i--){
            factorial = factorial*i;
        }

        System.out.println(factorial);
    }

    private static void findLongestWord() {
        String word = "I love dogs";

        Collection<String> ls3 = Arrays.stream(word.split(" ")).collect(Collectors.toList());
        int longest = 0;
        String lonestWord = null;
        for (String s: ls3) {

            if( s.length() > longest){
                lonestWord = s;
                longest = s.length();

            }


        }System.out.println(lonestWord);
    }

    private static void findCommon() {
        String[] array= {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};

        /*List<String> ls = Arrays.stream(array).flatMap(ele -> Arrays.stream(ele.split(","))).
                collect(Collectors.toList()).stream().map(ele -> ele.trim()).
                collect(Collectors.toList());*/

        Collection<String> ls1 = Arrays.stream(array[0].split(",")).map(ele -> ele.trim()).collect(toCollection(TreeSet::new));
        Collection<String> ls2 = Arrays.stream(array[1].split(",")).map(ele -> ele.trim()).collect(toCollection(TreeSet::new));

        ls1.retainAll(ls2);

        for (String s: ls1) {
            System.out.println(s);
        }
    }
}
