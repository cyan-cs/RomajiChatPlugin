package core.java;

import org.bukkit.plugin.java.JavaPlugin;
import core.java.listener.ChatListener;

/**
 * メインプラグインクラス
 * プラグインの有効化・無効化、イベントリスナー登録を行います
 */
public class RomajiChatPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // ChatListenerにプラグインインスタンスを渡す
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getLogger().info("RomajiChatPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RomajiChatPlugin has been disabled!");
    }
}
