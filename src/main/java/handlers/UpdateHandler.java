package handlers;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class UpdateHandler extends TelegramLongPollingBot {

    @Autowired
    private Properties properties;

    @Override
    public void onUpdateReceived(Update update) {
        //check if the update has a message
        if (update.hasMessage()) {
            Message message = update.getMessage();

            //check if the message has text. it could also  contain for example a location ( message.hasLocation() )
            if (message.hasText()) {

                //create a object that contains the information to send back the message
                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
//                sendMessageRequest.setText("you said: " + message.getText());
                sendMessageRequest.setText("Трамвай №3 прибуває через 5хв \n Марш №45 прибуває через 10хв" );
                try {
                    sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
                } catch (TelegramApiException e) {
                    log.error("{}", e);
                }
            }
        }

    }//end onUpdateReceived()

    @Override
    public String getBotUsername() {
        return "user";
    }

    @Override
    public String getBotToken() {
//        return properties.getToken();
    }

    private void sendMessage(SendMessage sendMessage) throws TelegramApiException {
        execute(sendMessage);
    }

    @Getter
    @Setter
    @ConfigurationProperties("bot")
    static class Properties {
        String token;
    }
}
