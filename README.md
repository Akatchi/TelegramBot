# Get started!

###### To get started with this code base follow the next steps:


1. Pull the code from github or download the project as .zip.
2. Import the project in your favorite IDE (the project was created in IntelliJ).
3. Change app.properties.example to app.properties (and fill in the values specified in the example file).
 - If you haven't registered a bot yet go to the following link to do so (talk to the @BotFatherbot on Telegram) https://core.telegram.org/bots
4. Add your desired commands to the commands package (Where ShrugCommand is right now).
 - For full documentation on what you can do check out the following url: https://github.com/nixtabyte/JTeleBot-Core/blob/master/src/main/java/io/github/nixtabyte/telegram/jtelebot/request/factory/TelegramRequestFactory.java
5. Update the CommandFactory to work with your custom command.
6. Launch the Java application (or host it on a server).
7. Enjoy!


------
Credits for the Telegram library goes to the creator of the following libraries:
- https://github.com/nixtabyte/JTeleBot-Server
- https://github.com/nixtabyte/JTeleBot-Core (The files io.github.nixtabyte.telegram.jtelebot.response.json.User.java and io.github.nixtabyte.telegram.jtelebot.response.json.GroupChat.java have been updated in this project. This is done because the library state on github contained some errors.)
