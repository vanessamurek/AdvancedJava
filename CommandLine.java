import java.io.IOException;

/**
 * Created by Vanessa Murek on 26.10.2016.
 */
public class CommandLine {


    public static void main(String[] args) throws IOException {
        FastaTool ft = new FastaTool();
        try {
            ft.parser(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }



        double blocks = Math.ceil((double) Sequence.averageBefore(ft)/59);

        for(int currBlock = 0 ; currBlock < blocks; currBlock++){
            System.out.printf("%-30s", "");
            System.out.printf("%-55s %-50s", 59*currBlock+1, (59*currBlock+1)+58);
            System.out.println();

            for (int i = 0; i < ft.getSequences().size(); i++) {
                System.out.printf("%-30s", ft.getHeaders().get(i));
                System.out.printf("%-50s", ft.getSequences().get(i).substring(59*currBlock, 59*(currBlock+1)) + "\n");
            }
            System.out.println();
        }

        System.out.print("Number of sequences: " + Sequence.howMany(ft) + "\n");
        System.out.print("Shortest length: " + Sequence.shortestBefore(ft) + " (excluding '-'s: " + Sequence.shortestAfter(ft)
                + ")\n");
        System.out.print("Average length: " + Sequence.averageBefore(ft) + " (excluding '-'s: " + Sequence.averageAfter(ft)
                + ")\n");
        System.out.print("Longest length: " + Sequence.longestBefore(ft) + " (excluding '-'s: " + Sequence.longestAfter(ft)
                + ")\n");
        System.out.print("Counts: A: " + Nucleotide.countOccurrences(ft, "A") +
                ", C: " + Nucleotide.countOccurrences(ft, "C") +
                        ", G: " + Nucleotide.countOccurrences(ft, "G") +
                        ", U: " + Nucleotide.countOccurrences(ft, "U") +
                        ", -: " + Nucleotide.countOccurrences(ft, "-")) ;
                    }
}
