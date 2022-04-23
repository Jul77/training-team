package trainingLibrary.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import trainingLibrary.UIAction.UIMenu;
import trainingLibrary.config.AppConfig;

public class TrainingApplication {
    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var uiMenu = context.getBean(UIMenu.class);
            uiMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

