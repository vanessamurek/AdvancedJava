import java.util.ArrayList;

/**
 * Created by Vanessa Murek on 26.10.2016.
 */
public class Sequence {

    public static int howMany(FastaTool ft){
        int numSequences = ft.getSequences().size();
        return numSequences;
    }

    public static ArrayList<String> removeDashes(ArrayList<String> sequencesBefore){
        ArrayList<String> sequencesAfter = new ArrayList<String>();
        for(int i = 0; i < sequencesBefore.size(); i++){
            sequencesAfter.add(sequencesBefore.get(i).replaceAll("-",""));
        }
        return sequencesAfter;
    }

    public static int shortestSequenceLength(ArrayList<String> sequences){
        int shortest = sequences.get(0).length();
        for (int i = 0; i < sequences.size(); i++) {
            int number = sequences.get(i).length();
            if (number < shortest) shortest = number;
        }
        return shortest;
    }

    public static int longestSequenceLength(ArrayList<String> sequences){
        int longest = sequences.get(0).length();
        for (int i = 0; i < sequences.size(); i++) {
            int number = sequences.get(i).length();
            if (number > longest) longest = number;
        }
        return longest;
    }


    public static int shortestBefore(FastaTool ft) {
        ArrayList<String> sequencesBefore = ft.getSequences();
        int shortestBef = shortestSequenceLength(sequencesBefore);
        return shortestBef;
    }

    public static int shortestAfter(FastaTool ft) {
        ArrayList<String> sequencesBefore = ft.getSequences();
        int shortestAft = shortestSequenceLength(removeDashes(sequencesBefore));
        return shortestAft;
    }

    public static int longestBefore(FastaTool ft) {
        ArrayList<String> sequencesBefore = ft.getSequences();
        int longestBef = longestSequenceLength(sequencesBefore);
        return longestBef;
    }

    public static int longestAfter(FastaTool ft) {
        ArrayList<String> sequencesBefore = ft.getSequences();
        int longestAft = longestSequenceLength(removeDashes(sequencesBefore));
        return longestAft;
    }

    public static int averageBefore(FastaTool ft){
        ArrayList<String> sequencesBefore = ft.getSequences();
        int sum = 0;
        for (String seq : sequencesBefore) {
            sum += seq.length();
        }
        return sum / sequencesBefore.size();
    }

    public static int averageAfter(FastaTool ft){
        ArrayList<String> sequencesBefore = ft.getSequences();
        int sum = 0;
        for (String seq : removeDashes(sequencesBefore)) {
            sum += seq.length();
        }
        return sum / sequencesBefore.size();
    }

}
