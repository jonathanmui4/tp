package seedu.duke.command.workout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.exception.GetJackDException;
import seedu.duke.lists.WorkoutList;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateWorkoutCommandTest {
    private WorkoutList workoutList;
    private Storage storage;
    private Ui ui;

    @BeforeEach
    public void setUp() throws GetJackDException {
        createEmptyWorkoutList();
        storage = new Storage();
        ui = new Ui();
    }

    private void createEmptyWorkoutList() {
        workoutList = new WorkoutList();
    }

    @Test
    void executeUserCommand_validDataAddToEmptyWorkoutList_exerciseAdded() throws GetJackDException {
        try {
            int initialSize = workoutList.getAllWorkouts().size();
            CreateWorkoutCommand c = new CreateWorkoutCommand("workout", LocalDate.parse("2021-12-12"));
            c.executeUserCommand(workoutList, ui, storage);
            assertEquals(initialSize + 1, workoutList.getAllWorkouts().size());
        } catch (GetJackDException e) {
            e.printStackTrace();
        }
    }
}
