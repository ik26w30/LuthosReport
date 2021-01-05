package org.ik26w30.luthos.reportluthos.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }

        if(args.length == 2){
            Player target = Bukkit.getPlayer(args[0]);
            if(target != null){
                if(target != sender){
                    String reason = args[1];
                    if(reason != null){
                        sender.sendMessage("§cPlayer succesfully reported");
                        Bukkit
                                .getOnlinePlayers()
                                .stream()
                                .filter(player -> player.hasPermission("report.admin"))
                                .forEach(player -> player.sendMessage("§cPlayer " + target.getName() + " has been reported by " + sender.getName() + " reason: " + reason));
                    }
                }else {
                    sender.sendMessage("§cYou can't report yourself");
                    return true;
                }
            }else {
                sender.sendMessage("§cPlayer to report not found");
                return true;
            }
        }else {
            sender.sendMessage("§cError: use /report [player-name] [reason]");
            return true;
        }
        return false;
    }
}
