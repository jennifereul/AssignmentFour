//"Write a program that given a String representation of a DNA sequence and returns its transcribed RNA
//sequence."

//Sample Input
//AGCTGGGAAACGTAGGCCTA
//Sample Output
//AGCUGGGAAACGUAGGCCUA
//Sample Input
//TTTTTTTTTTGGCGCG
//Sample Output
//UUUUUUUUUUGGCGCG

//Notable differences
//DNA containes T, RNA contains U
//A, C, and G are unchanged
import java.util.Stack;
public class QuestionFive {

    public static String transcribeDNAToRNA(String dnaSequence) {
        Stack<Character> rnaStack = new Stack<>();

        for (int i = 0; i < dnaSequence.length(); i++) {
            char nucleobase = dnaSequence.charAt(i);
            if (nucleobase == 'T') {
                rnaStack.push('U');
            } else {
                rnaStack.push(nucleobase);
            }
        }

        StringBuilder rnaSequence = new StringBuilder();
        while (!rnaStack.isEmpty()) {
            rnaSequence.insert(0, rnaStack.pop());
        }

        return rnaSequence.toString();
    }

    public static void main(String[] args) {
        // Sample Input
        String[] dnaSequences = {
                "AGCTGGGAAACGTAGGCCTA",
        };

        // Print results of T & U swaps
        for (int i = 0; i < dnaSequences.length; i++) {
            String dnaSequence = dnaSequences[i];
            String rnaSequence = transcribeDNAToRNA(dnaSequence);
            System.out.println(rnaSequence);
        }
    }
}


