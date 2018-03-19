import controller.userSelectController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/userSelectWindow.fxml"));
        loader.setController(new userSelectController());
        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("User selection");

        //primaryStage.setFullScreen(true);
        //primaryStage.setFullScreenExitHint("");
        primaryStage.show();


    }

    public static void main(String[] args)
    {

        launch(args);

    }





}

