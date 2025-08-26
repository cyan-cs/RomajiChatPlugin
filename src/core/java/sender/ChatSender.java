package core.java.sender;

import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * 変換済みメッセージをチャット欄に送信するユーティリティ
 */
public class ChatSender {

    public static void sendToChat(AsyncPlayerChatEvent event, String message) {
        if (event == null || message == null) return;
        event.setMessage(message); // チャット欄に反映
    }
}
