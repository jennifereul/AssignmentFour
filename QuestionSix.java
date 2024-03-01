import java.util.Stack;

public class QuestionSix {

    public static String translate(String rna) {
        String[] codonTable = {"UUU","UUC","UUA","UUG","CUU","CUC","CUA","CUG","AUU","AUC","AUA","AUG","GUU","GUC","GUA","GUG","UCU","UCC","UCA","UCG","CCU","CCC","CCA","CCG","ACU","ACC","ACA","ACG","GCU","GCC","GCA","GCG","UAU","UAC","UAA","UAG","CAU","CAC","CAA","CAG","AAU","AAC","AAA","AAG","GAU","GAC","GAA","GAG","UGU","UGC","UGA","UGG","CGU","CGC","CGA","CGG","AGU","AGC","AGA","AGG","GGU","GGC","GGA","GGG"};
        char[] aminoAcids = {'F','F','L','L','L','L','L','L','I','I','I','M','V','V','V','V','S','S','S','S','P','P','P','P','T','T','T','T','A','A','A','A','Y','Y','.','.','H','H','Q','Q','N','N','K','K','D','D','E','E','C','C','.','W','R','R','R','R','S','S','R','R','G','G','G','G'};

        Stack<Character> stack = new Stack<>();
        boolean lastIsStopCodon = false;

        for (int i = 0; i + 3 <= rna.length(); i += 3) {
            String codon = rna.substring(i, i + 3);

            int index = -1;
            for (int j = 0; j < codonTable.length; j++) {
                if (codonTable[j].equals(codon)) {
                    index = j;
                    break;
                }
            }

            if (index != -1 && (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA"))) {
                lastIsStopCodon = true;
                break;
            }

            if (index != -1) {
                stack.push(aminoAcids[index]);
            }
        }

        String protein = "";
        while (!stack.isEmpty()) {
            protein = stack.pop() + protein;
        }

        if (!protein.isEmpty() && !lastIsStopCodon) {
            protein += '.';
        }

        return protein;
    }
    //Not returning correctly ):
    public static void main(String[] args) {
        String input1 = "AGCUGGGAAACGUAGGCCUA";
        String input2 = "UAAAGAGAAGCCAGC";

        System.out.println(translate(input1));
        System.out.println(translate(input2));
    }
}
