package factories;

import commands.MagicCommand;
import commands.ShrugCommand;
import controllers.PropertiesController;
import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.Command;
import org.apache.log4j.Logger;
import settings.Constants;

/**
 * Created by Vasco on 11/11/2015.
 * In this factory add the differnet comands your bot supports
 */
public class CommandFactory implements io.github.nixtabyte.telegram.jtelebot.server.CommandFactory
{
    private static final Logger LOG = Logger.getLogger(CommandFactory.class);

    @Override
    // This method retrieves the commands from the users
    // So in here add your custom commands
    public Command createCommand(Message message, RequestHandler requestHandler)
    {
        LOG.info("Message: " + message.getText());

        if( equalsCommand(message.getText(), "/shrug") )
        {
            return new ShrugCommand(message, requestHandler);
        }
        else if( equalsCommand(message.getText(), "/magic") )
        {
            return new MagicCommand(message, requestHandler);
        }

        return null;
    }

    // This method will check if the commamnd from the user
    // matches the command specified for the action
    // It will automaticly check it by comparing the command
    // with the action command and the action command + app name since both formats
    // are possible (/shrug vs /shrug@BotName, both are possible
    // calls for the command)
    // The BotNAme is being taken from the property file
    private boolean equalsCommand(String messageText, String command)
    {
        if( messageText.equalsIgnoreCase(command) ||
            messageText.equalsIgnoreCase(command + "@" + PropertiesController.getInstance().getProperty(Constants.KEY_BOT_NAME)) )
        {
            return true;
        }

        return false;
    }
}
