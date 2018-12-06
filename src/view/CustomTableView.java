package view;

import bean.DocumentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by emcc on 2018/12/6.
 */
public class CustomTableView extends Pane {


    public CustomTableView(){
        getChildren().add(createTableByObject());
    }

    // 根据对象属性创建table
    public TableView<DocumentData> createTableByObject() {
        TableView<DocumentData> tableView = new TableView();
        addDocumentColumns(tableView);
//        averageColumnsWidth(tableView);
        tableView.setItems(getDate());
        return tableView;
    }

    private void addDocumentColumns(TableView<DocumentData> tableView) {
        TableColumn<DocumentData, Integer> idColumn = new TableColumn<>("文档ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<DocumentData, Integer>(
                "id"));
        idColumn.setMinWidth(50);
        tableView.getColumns().add(idColumn);
        TableColumn<DocumentData, String> nameColumn = new TableColumn<>("文档名");
        nameColumn.setCellValueFactory(new PropertyValueFactory<DocumentData, String>(
                "name"));
        nameColumn.setMinWidth(50);
        tableView.getColumns().add(nameColumn);
        TableColumn<DocumentData, String> remarkColumn = new TableColumn<>("备注");
        remarkColumn.setCellValueFactory(new PropertyValueFactory<DocumentData, String>(
                        "remark"));
        remarkColumn.setMinWidth(50);
        tableView.getColumns().add(remarkColumn);
        TableColumn<DocumentData,Boolean> checkBoxColumn = new TableColumn<>("选中");
        checkBoxColumn.setCellValueFactory(new PropertyValueFactory<DocumentData, Boolean>(
                        "select"));
        checkBoxColumn.setCellFactory(new Callback<TableColumn<DocumentData, Boolean>, TableCell<DocumentData, Boolean>>() {
            @Override
            public TableCell<DocumentData, Boolean> call(TableColumn<DocumentData, Boolean> param) {
                CheckBoxTableCell<DocumentData, Boolean> cell = new CheckBoxTableCell<>();
                cell.setAlignment(Pos.CENTER);
                return cell;
            }
        });
        tableView.getColumns().add(checkBoxColumn);

    }
    private  ObservableList<DocumentData>  getDate(){
        ObservableList<DocumentData> personData = FXCollections.observableArrayList();
        for (int i=0;i<100;i++){
            DocumentData child = new DocumentData();
            child.setId(i);
            child.setName("i=="+i);
            child.setRemark("remark=="+i);
            personData.add(child);
        }
        return personData;
    }
}
