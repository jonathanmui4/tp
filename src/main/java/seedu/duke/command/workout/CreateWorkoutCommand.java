package seedu.duke.command.workout;

import seedu.duke.command.Command;
import seedu.duke.exception.GetJackDException;
import seedu.duke.lists.Workout;
import seedu.duke.lists.WorkoutList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

/**
 * To create a new Workout
 */

import static seedu.duke.parser.Parser.WORKOUT_KEYWORD;

public class CreateWorkoutCommand extends Command {
    public static final String COMMAND_WORD = "create";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a new workout.\n"
            + "\tParameters: " + WORKOUT_KEYWORD + "WORKOUT_NAME\n"
            + "\tExample: " + COMMAND_WORD + " " + WORKOUT_KEYWORD + "ab workout";
    public static final String MESSAGE_SUCCESS = "New workout created: %1$s";
    private final Workout toCreate;

    /**
     * Instantiates object and creates a new workout.
     * @param description description of new workout.
     */
    public CreateWorkoutCommand(String description) {
        this.toCreate = new Workout(description);
    }

    @Override
    public void executeUserCommand(WorkoutList workouts, Ui ui, Storage storage) throws GetJackDException {
        workouts.addWorkout(toCreate);
        ui.showToUser(String.format(MESSAGE_SUCCESS, toCreate));
        String jsonString = storage.convertToJson(workouts);
        storage.saveData(jsonString);
    }
}