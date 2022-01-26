module ru.java3000.opennotefx {
    uses ru.java3000.opennotefx.services.RemoteService;
    provides ru.java3000.opennotefx.services.RemoteService
            with ru.java3000.opennotefx.services.remotes.BasicService;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jakarta.xml.bind;
    requires jakarta.activation;

    opens ru.java3000.opennotefx to javafx.fxml;
    exports ru.java3000.opennotefx;
    exports ru.java3000.opennotefx.services;
    opens ru.java3000.opennotefx.services to javafx.fxml;
    exports ru.java3000.opennotefx.entities;
    opens ru.java3000.opennotefx.entities to javafx.fxml, jakarta.xml.bind;
    exports ru.java3000.opennotefx.controllers;
    opens ru.java3000.opennotefx.controllers to javafx.fxml;
    exports ru.java3000.opennotefx.services.remotes;
    opens ru.java3000.opennotefx.services.remotes to javafx.fxml;
}

