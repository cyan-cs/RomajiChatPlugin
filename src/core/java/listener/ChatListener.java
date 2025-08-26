package core.java.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import core.java.converter.RomajiConverter;
import core.java.sender.ChatSender;

/**
 * プレイヤーのチャットを監視し、ローマ字で始まる場合に変換して送信するリスナー
 */
public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String originalMessage = event.getMessage();
        if (originalMessage == null) return;

        originalMessage = originalMessage.trim();
        if (!originalMessage.startsWith(".")) return; //Prefixを設定

        String romajiMessage = originalMessage.substring(1); // "." を除去
        if (romajiMessage.isEmpty()) return;

        String hiraganaMessage;
        try {
            hiraganaMessage = RomajiConverter.convert(romajiMessage);
        } catch (Exception e) {
            // 変換失敗時は元のメッセージを送信
            hiraganaMessage = romajiMessage;
        }

        ChatSender.sendToChat(event, hiraganaMessage);
    }
}
