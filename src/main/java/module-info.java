module ru.java3000.note {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
            
    opens ru.java3000.note to javafx.fxml;
    exports ru.java3000.note;
}