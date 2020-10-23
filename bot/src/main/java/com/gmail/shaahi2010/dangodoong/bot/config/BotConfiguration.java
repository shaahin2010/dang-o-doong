package com.gmail.shaahi2010.dangodoong.bot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.BotSession;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class BotConfiguration {
    @Value("${dangodoong.username}")
    private String botUsername;
    @Value("${dangodoong.token}")
    private String botToken;
    @Value("${dangodoong.proxy.enable:false}")
    private boolean proxyEnabled;

    @Bean
    public TelegramBotsApi telegramBotsApi() throws TelegramApiRequestException {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        BotSession botSession = telegramBotsApi.registerBot(dangoDoongBot());
        return telegramBotsApi;
    }

    @Bean
    public DefaultBotOptions defaultBotOptions() {
        DefaultBotOptions botOptions = new DefaultBotOptions();
        if (proxyEnabled) {
            botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
            botOptions.setProxyHost("localhost");
            botOptions.setProxyPort(1080);
        }
        return botOptions;
    }

    @Bean
    public DangoDoongBot dangoDoongBot() {
        return new DangoDoongBot(botUsername, botToken, defaultBotOptions());
    }

}
