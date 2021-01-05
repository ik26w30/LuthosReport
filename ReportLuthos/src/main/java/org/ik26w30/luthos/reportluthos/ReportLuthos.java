package org.ik26w30.luthos.reportluthos;

import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.luthos.reportluthos.commands.ReportCommand;

public final class ReportLuthos extends JavaPlugin {
    private ReportLuthos instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        registerCommands();
    }

    private void registerCommands() {
        this.getCommand("report").setExecutor(new ReportCommand());
    }

}
