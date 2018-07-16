package demo;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class Hello extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().add(createTable());
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private final ObservableList<Object[]> data = observableArrayList(
            new Object[]{"AAA", 111},
            new Object[]{"BBB", 222},
            new Object[]{"CCC", 333}
    );

    private TableView<Object[]> createTable() {
        return new TableView<Object[]>() {{
            getColumns().add(new TableColumn<Object[], String>("String") {{
                setCellValueFactory(param -> {
                    String value = (String) param.getValue()[0];
                    return new SimpleStringProperty(value);  // SimpleStringProperty is `ObservableValue`
                });
            }});
            getColumns().add(new TableColumn<Object[], Integer>("Number") {{
                setCellValueFactory(param -> {
                    Integer value = (Integer) param.getValue()[1];
                    return new SimpleIntegerProperty(value).asObject(); // SimpleIntegerProperty is not `ObservableValue`
                });
            }});
            setItems(data);
            setEditable(true);
        }};
    }
}
