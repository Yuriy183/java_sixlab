import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Comparator;

public class Controller {

    @FXML
    public TextArea textAreaJSON;

    @FXML
    public Button btnSortName;

    @FXML
    public Button btnSortRarity;

    @FXML
    public Button btn;

    JSONGetter gj = new JSONGetter();
    Examples examples = new Examples();

    public void getJSON(ActionEvent actionEvent) throws InterruptedException, IOException {
        gj.start();
        String json = gj.getJson();

        do {
            Thread.sleep(100);
        } while ((json = gj.getJson()) == null);

        examples = Examples.fromJSONToObjects(json);
        textAreaJSON.setText(examples.getExamples().toString());

        btnSortName.setDisable(false);
        btnSortRarity.setDisable(false);
        btn.setDisable(true);
    }

    public void btnSortYear(ActionEvent actionEvent) {
        examples.getExamples().sort((Comparator)Example.byNameAsc);
        textAreaJSON.setText(examples.getExamples().toString());
    }

    public void btnSortRelease(ActionEvent actionEvent) {
        examples.getExamples().sort((Comparator)Example.byValueDesc);
        textAreaJSON.setText(examples.getExamples().toString());
    }
}