package com.gmail.shaahi2010.dangodoong.bot.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Iterator;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class DangoDoongBot extends TelegramLongPollingBot {
    @Getter
    private final String botUsername;
    @Getter
    private final String botToken;

    public DangoDoongBot(String botUsername, String botToken, DefaultBotOptions options) {
        super(options);
        this.botUsername = botUsername;
        this.botToken = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.info(update.getMessage().getText());
        log.info(update.getMessage().getFrom().getUserName());
        log.info(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Iterator<Update> iterator = updates.iterator(); iterator.hasNext(); ) {
            Update update = iterator.next();
            String messageText = update.getMessage().getText();
            String userName = update.getMessage().getFrom().getUserName();
            String fullName = update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName();
            log.info(messageText);
            log.info(userName);
            log.info(fullName);
            Long chatId = update.getMessage().getChatId();
            SendMessage sendMessage = new SendMessage(chatId, "I got:\n" +
                    messageText);
            try {
                Message execute = execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
