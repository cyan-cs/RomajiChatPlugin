package core.java.converter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.Gson;

/**
 * ローマ字をひらがなに自動変換するクラス
 * JSON で変換マップを管理
 * 小書き文字、濁点・半濁点、促音、長音にも対応
 */
public class RomajiConverter {

    private static final Map<String, String> romajiMap = new HashMap<>();

    static {
        // JSON を resources から読み込む
        try (InputStream is = RomajiConverter.class.getResourceAsStream("/romaji_map.json")) {
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                Gson gson = new Gson();
                Map<String, String> map = gson.fromJson(reader, Map.class);
                romajiMap.putAll(map);
            } else {
                System.err.println("romaji_map.json が見つかりません");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convert(String romaji) {
        if (romaji == null) return "";
        romaji = romaji.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < romaji.length(); ) {
            // 数字・記号はそのまま
            char c = romaji.charAt(i);
            if (!Character.isLetter(c)) {
                sb.append(c);
                i++;
                continue;
            }

            // nn → ん
            if (i + 1 < romaji.length() && romaji.charAt(i) == 'n' && romaji.charAt(i + 1) == 'n') {
                sb.append("ん");
                i += 2;
                continue;
            }

            // 促音（小さい「っ」）
            if (i + 1 < romaji.length() && romaji.charAt(i) == romaji.charAt(i + 1)
                    && isConsonant(c) && c != 'n') {
                sb.append("っ");
                i++;
                continue;
            }

            // 三文字マッチ優先
            if (i + 2 < romaji.length()) {
                String three = romaji.substring(i, i + 3);
                String mapped = romajiMap.get(three);
                if (mapped != null) {
                    sb.append(mapped);
                    i += 3;
                    continue;
                }
            }

            // 二文字マッチ
            if (i + 1 < romaji.length()) {
                String two = romaji.substring(i, i + 2);
                String mapped = romajiMap.get(two);
                if (mapped != null) {
                    sb.append(mapped);
                    i += 2;
                    continue;
                }
            }

            // 小書き文字（la, li, lyu など）
            if (i + 1 < romaji.length()) {
                String small = romajiMap.get("" + romaji.charAt(i) + romaji.charAt(i + 1));
                if (small != null) {
                    sb.append(small);
                    i += 2;
                    continue;
                }
            }

            // 単音
            String single = romajiMap.get("" + romaji.charAt(i));
            if (single != null) {
                sb.append(single);
            } else {
                sb.append(romaji.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }

    private static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(c) >= 0;
    }
}
