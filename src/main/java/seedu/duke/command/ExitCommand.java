package seedu.duke.command;

import seedu.duke.exception.GetJackDException;
import seedu.duke.lists.WorkoutList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.util.logging.Logger;

import static seedu.duke.logger.LoggerUtil.setupLogger;

/**
 * Used to exit the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = "bye: Closes the program"
            + "\tExample: bye";
    private static final Logger LOGGER = Logger.getLogger(ExitCommand.class.getName());

    public static boolean isExit(Command command) {
        setupLogger(LOGGER);
        LOGGER.info("End program");
        return command instanceof ExitCommand;
    }

    @Override
    public void executeUserCommand(WorkoutList workouts, Ui ui, Storage storage) throws GetJackDException {
    }
}
