package com.gmail.shaahi2010.dangodoong.bot.main;

import com.gmail.shaahi2010.dangodoong.bot.config.DangoDoongBot;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MainClass {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        botOptions.setProxyHost("localhost");
        botOptions.setProxyPort(1080);

        HttpHost httpHost = new HttpHost("localhost", 1080);

        RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(false).build();
        botOptions.setRequestConfig(requestConfig);

        try {
            telegramBotsApi.registerBot(new DangoDoongBot(System.getProperty("dangodoong.username"),
                    System.getProperty("dangodoong.token"), botOptions
            ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
