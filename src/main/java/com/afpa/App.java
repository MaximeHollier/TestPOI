package com.afpa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        Label label = new Label(getPr());
        window.setScene(new Scene(label,500,500));
        window.show();
    }

    public String getPr() throws IOException
    {
        Excell excell = new Excell("C:\\Users\\Maxime\\IdeaProjects\\TestPOI\\src\\main\\java\\com\\afpa\\Planning2019.xlsx");
        ArrayList<Integer> arrayList = excell.compterPr();
        String sRet = "";
        for(Integer integer : arrayList)
        {
            sRet+=integer+"\n";
        }
        return sRet;
    }
}
