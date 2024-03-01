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
public class QuestionFive {

    public static String transcribeDNAToRNA(String dnaSequence) {
        String rnaSequence = "";
        //converts input into array, allowing for easy iteration over characters
        char[] dnaArray = dnaSequence.toCharArray();
        for (int i = 0; i < dnaArray.length; i++) {
            char nucleobase = dnaArray[i];
            //if the nucleobase is T, we change it to U
            if (nucleobase == 'T') {
                rnaSequence += 'U';
                //of it includes other letters/the ones that stay the same. We keep them.
            } else {
                rnaSequence += nucleobase;
            }
        }
        return rnaSequence;
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

