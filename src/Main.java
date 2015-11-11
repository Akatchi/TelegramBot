import controllers.PropertiesController;
import factories.CommandFactory;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandDispatcher;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandQueue;
import io.github.nixtabyte.telegram.jtelebot.server.impl.DefaultCommandWatcher;
import settings.Constants;

/**
 * Created by Vasco on 11/11/2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Variables applied to the commanddispatcher:
        // int threadPoolSize, int taskListCapacity, long delay, CommandQueue commandQueue
        DefaultCommandDispatcher commandDispatcher = new DefaultCommandDispatcher(10, 100, 0,
                new DefaultCommandQueue());
        commandDispatcher.startUp();

        // Variables applied to teh commandwatcher:
        // long delayInMillis, int cacheCapacity, String telegramToken,
        // CommandDispatcher commandDispatcher, CommandFactory commandFactory
        DefaultCommandWatcher commandWatcher = new DefaultCommandWatcher(2000, 100,
                PropertiesController.getInstance().getProperty(Constants.KEY_API_KEY),
                commandDispatcher, new CommandFactory());
        commandWatcher.startUp();
    }
}
