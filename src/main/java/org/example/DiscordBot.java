package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.response.ChattingReaction;

import java.util.EnumSet;

public class DiscordBot {

    public static void main(String[] args) {
        BotTokenManager tokenManager = new BotTokenManager();
        String token = tokenManager.getDiscordBotToken();

        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.MESSAGE_CONTENT
                );

        JDABuilder.createDefault(token)
                .enableIntents(intents)
                .setActivity(Activity.customStatus("명령어 기다리는 중..."))
                .addEventListeners(new ChattingReaction())
                .build();
    }
}