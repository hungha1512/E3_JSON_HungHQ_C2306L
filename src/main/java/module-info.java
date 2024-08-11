module com.hunghq.e3_json_hunghq_c2306l {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;
    requires jbcrypt;

    opens com.hunghq.e3_json_hunghq_c2306l to javafx.fxml;
    exports com.hunghq.e3_json_hunghq_c2306l;
}