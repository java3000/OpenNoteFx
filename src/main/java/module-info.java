module ru.java3000.note {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.themify;
    requires jakarta.xml.bind;

    opens ru.java3000.note to javafx.fxml;
    opens ru.java3000.note.controllers to javafx.fxml;
    opens ru.java3000.note.entities to javafx.fxml;
    opens ru.java3000.note.services to javafx.fxml;

    exports ru.java3000.note;
    exports ru.java3000.note.controllers;
    exports ru.java3000.note.entities;
    exports ru.java3000.note.services;
}