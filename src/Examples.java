import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Examples<byValueDesc, byValueAsc, byNameDesc, byNameAsc> {

    public ArrayList<Example> getExamples() {
        return examples;
    }

    public Examples(ArrayList<Example> examples) {
        this.examples = examples;
    }

    public void setRates(ArrayList<Example> examples) {
        this.examples = examples;
    }

    private ArrayList<Example> examples;

    public Examples() {
        examples = new ArrayList<>();
    }

    public void add(Example examples) {
        this.examples.add(examples);
    }

    @Override
    public String toString() {
        String result = "Films (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (Example c : examples) {
            result += c + System.lineSeparator();
        }
        return result;
    }
    public static Examples fromJSONToObjects(String jsonData) throws IOException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonData, Examples.class);
    }
}