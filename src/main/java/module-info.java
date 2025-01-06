module com.exam.exam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.exam.exam to javafx.fxml;
    exports com.exam.exam;
}