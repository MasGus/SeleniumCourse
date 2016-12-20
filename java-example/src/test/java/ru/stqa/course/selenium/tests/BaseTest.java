package ru.stqa.course.selenium.tests;

import org.junit.Before;
import ru.stqa.course.selenium.app.Application;

/**
 * Created by Maria.Guseva on 20.12.2016.
 */
public class BaseTest {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    @Before
    public void start() {
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }

}
