package commands;

import io.github.nixtabyte.telegram.jtelebot.client.RequestHandler;
import io.github.nixtabyte.telegram.jtelebot.exception.JsonParsingException;
import io.github.nixtabyte.telegram.jtelebot.request.TelegramRequest;
import io.github.nixtabyte.telegram.jtelebot.request.factory.TelegramRequestFactory;
import io.github.nixtabyte.telegram.jtelebot.response.json.Message;
import io.github.nixtabyte.telegram.jtelebot.server.impl.AbstractCommand;

/**
 * Created by Vasco on 11/11/2015.
 */
public class MagicCommand extends AbstractCommand
{
    public MagicCommand(Message message, RequestHandler requestHandler)
    {
        super(message, requestHandler);
    }

    @Override
    public void execute()
    {
        try
        {
            // The followign piece is documentation form the TelegramRequestFacotyr
            // It contains finroamtion about the parameters
            /**
             *
             * Creates a Telegram request ready to use to consume the sendMessage method of the Telegram bot api
             *
             * @param chatId Unique identifier for the message recipient ��� User or GroupChat id
             * @param text Text of the message to be sent
             * @param disableWebPagePreview Optional - Disables link previews for links in this message
             * @param replyToMessageId	Optional - If the message is a reply, ID of the original message
             * @param customReplyKeyboard Optional - Additional interface options. A JSON-serialized object for a custom reply keyboard, instructions to hide keyboard or to force a reply from the user.
             * @return A TelegramRequest prepared to consume the sendMessage method
             * @see TelegramRequest
             * @throws org.codehaus.jackson.JsonGenerationException if any.
             * @throws org.codehaus.jackson.map.JsonMappingException if any.
             * @throws java.io.IOException if any.
             * @throws JsonParsingException
             */
            TelegramRequest request = TelegramRequestFactory.createSendMessageRequest(
                    message.getChat().getId(), "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ✧ﾟ･: *ヽ(◕ヮ◕ヽ)", true, null, null
            );

            requestHandler.sendRequest(request);
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}
