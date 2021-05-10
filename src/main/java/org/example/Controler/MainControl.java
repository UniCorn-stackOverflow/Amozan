package org.example.Controler;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.example.DaoResources.CustomerDaoMariaDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

/**
 * JavaFX MainControl
 */
public class MainControl extends Application implements EventHandler<WindowEvent>
{

    private static Scene scene;
    private static Locale locale;
    @Override
    public void start(Stage stage) throws IOException {
        stage.setOnCloseRequest(this);
        scene = new Scene(loadFXML("login"));
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception{}
    @Override
    public void handle(WindowEvent event)
    {
        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        try
        {
            daoM.deleteOnExit();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static Locale getLocale()
    {
        if(locale == null)
        {
            locale = new Locale("de", "DE");

        }
        return locale;
    }
    public static void setLocale(Locale newLocale)
    {
        locale = newLocale;
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainControl.class.getResource("/org/example/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}