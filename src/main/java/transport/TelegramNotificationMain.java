package transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

@SpringBootApplication
public class TelegramNotificationMain {

    public static void main(String[] args) {
        SpringApplication.run(TelegramNotificationMain.class);

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

    }
}
