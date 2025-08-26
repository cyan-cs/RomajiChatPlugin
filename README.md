# RomajiChatPlugin - やきいも
## 1. RomajiChatPluginの詳細情報
**RomajiChatPlugin**は、MinecraftのPaperサーバー向けプラグインで、チャットで入力されたローマ字を自動でひらがなに変換します。  
数字・記号・促音・拗音・濁点・半濁点・小文字など、日本語入力でよく使われる表現に幅広く対応しています。

## 2. 特徴
- プレイヤーのチャットでローマ字を自動変換  
- 小書き文字（ぁぃぅぇぉ、ゃゅょ、ゎ）に対応  
- 濁点・半濁点付き文字にも対応  
- 促音（っ）や長音も適切に変換  
- JSON形式のマップで簡単に変換ルールを拡張可能  

## 3. ゲーム内での使用方法
```text
.konnnichiha!
```
が
```
こんにちは!
```
になります。

## 4. サーバーでの使用方法
1. サーバーの`plugin`フォルダに`RomajiChat-x.x.x.jar`を配置
2. サーバーを再起動
3. チャットで`.`が一番最初にが付いたローマ字を入力すると自動でひらがなに変換されます

## 5. Jsonの拡張方法
`src\core\resources`にある`romaji_map.json`に新しいルールを追加して、変換のカスタマイズが可能です:
```
{
  "kya": "きゃ",
  "kyo": "きょ",
  "la": "ぁ",
  "li": "ぃ",
  "di": "ぢ",
  "du": "づ"
}
```

## 6. ライセンス
このリポジトリは[MIT License](https://opensource.org/licenses/MIT) で公開されています。

## 7. インストール方法

## 8. ソースをダウンロードして開発する場合
1. ターミナルで
```bash
clone https://github.com/cyan-cs/RomajiChatPlugin.git
```
を実行します。
3. ダウンロードしたZIPを解凍します。
4. ルートに`libs`,`build`フォルダを作成します。
5. `libs`フォルダに開発したいバージョンの[paperMC](https://papermc.io/downloads/all?project=paper) のjarファイルを入れます。
6. 開発します。
7. ルートでターミナルを開き、```gradle build```を実行します。
8. `build/libs`にjarファイルができて完成！！

## 9. 開発の裏話
- ねむい
- `やきいも`とかいうふざけたサブタイトルは[yh2237](https://github.com/yh2237)が考案したものです
- Discordサーバーにも入ってね
# - [ぱすた(Discordサーバー)](https://discord.gg/nq2tQXHAXt)
# - [X](https://x.com/dev_cyan)
