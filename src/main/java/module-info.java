module ru.java3000.yandexdrivetodofx {
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jakarta.xml.bind;
    requires jakarta.activation;

    opens ru.java3000.yandexdrivetodofx to javafx.fxml;
    exports ru.java3000.yandexdrivetodofx;
    exports ru.java3000.yandexdrivetodofx.services;
    opens ru.java3000.yandexdrivetodofx.services to javafx.fxml;
    exports ru.java3000.yandexdrivetodofx.entities;
    opens ru.java3000.yandexdrivetodofx.entities to javafx.fxml, jakarta.xml.bind;
    exports ru.java3000.yandexdrivetodofx.controllers;
    opens ru.java3000.yandexdrivetodofx.controllers to javafx.fxml;
}

