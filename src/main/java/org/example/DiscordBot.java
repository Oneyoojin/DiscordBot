package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordBot {

    public static void main(String[] args) {
        BotTokenManager tokenManager = new BotTokenManager();
        String token = tokenManager.getDiscordBotToken();
        JDABuilder.createDefault(token)
                .setActivity(Activity.competing("게임"))
                .setActivity(Activity.playing("봇 만들기"))
                .setActivity(Activity.playing("음악"))
                .setActivity(Activity.streaming("방송","링크"))
                .setActivity(Activity.watching("영화"))
                .setActivity(Activity.customStatus("명령어 기다리는중..."))
                .build();

    }

}
