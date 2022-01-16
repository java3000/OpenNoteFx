module com.example.yandexdrivetodofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires javafx.web;

    opens ru.java3000.yandexdrivetodofx to javafx.fxml;
    exports ru.java3000.yandexdrivetodofx;
}