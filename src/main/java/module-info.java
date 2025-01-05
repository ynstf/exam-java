module com.exam.exam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exam.exam to javafx.fxml;
    exports com.exam.exam;
}