import java.util.ArrayList;


/**
 * Created by Vanessa Murek on 26.10.2016.
 */
public class Nucleotide {

    public static int countOccurrences(FastaTool ft, String nucleotide){
        int occurrences = 0;
        ArrayList<String> sequences = ft.getSequences();
        for (int i = 0; i < sequences.size(); i++) {
            occurrences += (sequences.get(i).length() - sequences.get(i).replace(nucleotide, "").length());

        }
        return occurrences;
    }
}
