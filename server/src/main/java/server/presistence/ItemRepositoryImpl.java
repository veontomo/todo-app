package server.presistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.veontomo.todo.model.ItemStatus;
import com.veontomo.todo.model.Task;

/**
 * Implementation of {@link ItemRepository}.
 * 
 * It is a in-memory implementation of a repository.
 * @author Andrew
 *
 */
public class ItemRepositoryImpl implements ItemRepository {

    @Override
    public List<Task> getAll() {
        return new ArrayList<Task>(3) {{
            final Date now = new Date(System.currentTimeMillis());
            add(new Task(1l, "todo app", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), "user", now));
            add(new Task(2l, "add tests", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), "admin", now));
            add(new Task(3l, "add actuators", "finish the app", ItemStatus.INPROGRESS, new Date(System.currentTimeMillis()), "user", now));
        }};
    }

    @Override
    public Task save(Task item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Task> getUserTasks(String username) {
        // TODO Auto-generated method stub
        return null;
    }

}
