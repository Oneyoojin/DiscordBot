package org.example.response;

import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class SlashCommandReaction extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event){
        switch (event.getName()){
            case "ping":
                event.reply("Pong!").queue();
                break;
            case "reply":
                event.reply("Reply!").queue();
                break;
        }

    }
    @Override
    public void onGuildReady(GuildReadyEvent event){
        List<CommandData> commandDatas = new ArrayList<>();
        commandDatas.add(
                Commands.slash("ping", "Pong을 해줍니다.")
        );
        commandDatas.add(
                Commands.slash("reply", "Reply를 해줍니다.")
        );
        event.getGuild().updateCommands().addCommands(commandDatas).queue();


    }
};
