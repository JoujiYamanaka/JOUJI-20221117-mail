# JOUJI-20221117-mail
mailへメッセージを送信するサンプルです

## HOW TO USE
1.サンプル用のgoogleアカウントを作成する

2.googleアカウントで「アプリ パスワード」を作成する

　参考サイト：https://support.google.com/accounts/answer/185833?hl=ja&authuser=1

3.mail.propertiesに1と2で取得した内容を追記する。 場所「src/main/resources/mail.properties」

　mail.username=1で取得したメールアドレス

　mail.password=2で取得したアプリパスワード

4.ApplyPaidHolidaysDto.javaに2で取得した内容を追記する。 場所「src/main/java/apiSystem/dto/ApplyPaidHolidaysDto.javaの41行目」

　String mailAddress = "1で取得したメールアドレス";

5.postmanにrequest用APIのデータをimportする。場所「/JOUJI-20221117-mail/postmanImportdata」

6.importしたデータからの1.有給休暇メール申請サンプルを選択して、SENDボタンを押下する


## Development Environment
* Postman v9.13.2
* Spring Tool Suite 4 Version: 4.10.0.RELEASE

## Requirement
* Java 11
* Spring Boot Starter Parent 2.7.5
* Apache Commons Validator 1.4.0
* Project Lombok

## License
"2022 JoujiYamanaka" is under [MIT License](https://en.wikipedia.org/wiki/MIT_License).
