package com.xinyi.readdatafromhbase;

import com.xinyi.readdatafromhbase.service.ReadDataFromHbase;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;


public class ReadHbaseData extends Application {

    private String startTime ;
    private String endTime ;
    private static FastDateFormat fdfWithBar = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
    private static FastDateFormat fdfWithNoBar = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {



        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(20);
        flowPane.setPadding(new Insets(15,15,15,15));

        TextField tableName = new TextField ();
        tableName.setText("2019-06-26 00:00:00");
        tableName.clear();
        tableName.setPrefWidth(650);
        flowPane.getChildren().add(new Label("输入表名: "));
        flowPane.getChildren().add(tableName);

        TextField startTimeText = new TextField ();
        startTimeText.setText("2019-06-26 00:00:00");
        startTimeText.clear();
        startTimeText.setPrefWidth(160);
        flowPane.getChildren().add(new Label("开始时间: "));
        flowPane.getChildren().add(startTimeText);

        TextField endTimeText = new TextField ();
        endTimeText.setText("2019-06-26 00:00:00");
        endTimeText.clear();
        endTimeText.setPrefWidth(160);
        flowPane.getChildren().add(new Label("结束时间: "));
        flowPane.getChildren().add(endTimeText);

        Button button = new Button("查 询 ");
        flowPane.getChildren().add(button);
        flowPane.getChildren().add(new Label("注意格式：2019-06-26 00:00:00 "));

        TextArea textArea = new TextArea();
        textArea.setPrefSize(710,480);
        textArea.setEditable(false);
        flowPane.getChildren().add(textArea);

        Scene scene = new Scene(flowPane, 780, 550);
        stage.setScene(scene);
        stage.show();


        button.setOnAction(event -> {
            textArea.clear();
            startTime = startTimeText.getText();
            endTime = endTimeText.getText();
            String tbName = tableName.getText();

            if(tbName.equals("")){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("错误提示");
                alert.setHeaderText(null);
                alert.setContentText("表名不能为空！");
                alert.showAndWait();
            }else{
                try {
                    fdfWithNoBar.format(fdfWithBar.parse(startTime));
                    fdfWithNoBar.format(fdfWithBar.parse(endTime));
                    if(!startTime.equals("") && !endTime.equals("")){
                        List<String> rowData;
                        try {
                            rowData = ReadDataFromHbase.getDataFromHbase(startTime,endTime,tableName.getText().trim());
                            Iterator iterator = rowData.iterator();
                            textArea.appendText("数据条数: "+rowData.size()+"\n");
                            while(iterator.hasNext()){
                                textArea.appendText(iterator.next().toString()+"\n");
                            }
                        } catch (Exception e) {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("错误提示");
                            alert.setHeaderText(null);
                            alert.setContentText("表名错误，请重新输入!");
                            alert.showAndWait();
                        }
                    }
                } catch (ParseException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("错误提示");
                    alert.setHeaderText(null);
                    alert.setContentText("格式错误，请重新输入!");
                    alert.showAndWait();

                }
            }

        });

    }
}
