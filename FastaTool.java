import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vanessa Murek on 26.10.2016.
 */
public class FastaTool {
    ArrayList<String> headers = new ArrayList<String>();
    ArrayList<String> sequences = new ArrayList<String>();

        public void parser(String filepath) throws IOException {
            String currLine = null;
            String currSequence = "";

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currLine = br.readLine()) != null) {
                if (currLine.startsWith(">")){
                    this.headers.add(currLine);
                    if (currSequence != "") {
                        this.sequences.add(currSequence);
                        currSequence = "";
                    }
                }
                else{
                    currSequence += currLine;
                }
            }
            // Add the last sequence to ArrayList
            this.sequences.add(currSequence);


        }
    public ArrayList<String> getHeaders() {
        return headers;
    }

    public ArrayList<String> getSequences() {
        return sequences;
    }


    }


