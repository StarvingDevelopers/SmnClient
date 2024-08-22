package tech.starvingdevelopers;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.RenderingMode;
import com.teamdev.jxbrowser.view.javafx.BrowserView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Engine engine = Engine.newInstance(RenderingMode.HARDWARE_ACCELERATED);

        Browser browser = engine.newBrowser();

        browser.navigation().loadUrl("https://localhost/login");

        BrowserView view = BrowserView.newInstance(browser);

        Scene scene = new Scene(new BorderPane(view), 1280, 800);
        primaryStage.setTitle("SMN Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> engine.close());
    }

    public static void main(String[] args) {
        System.setProperty("jxbrowser.license.key", "ADICIONE SUA LICENÇA DO JXBROWSER AQUI!");
        launch(args);
    }
}
