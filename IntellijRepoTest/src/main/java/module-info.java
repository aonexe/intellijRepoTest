module com.intellijrepotest.intellijrepotest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.intellijrepotest.intellijrepotest to javafx.fxml;
    exports com.intellijrepotest.intellijrepotest;
}