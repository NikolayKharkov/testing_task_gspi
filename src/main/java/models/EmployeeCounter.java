package models;

import java.util.HashMap;
import java.util.List;

public class EmployeeCounter {
    public static int countUniqueEmployees(List<HashMap<String, String>> projectsTasks) {
        return projectsTasks
                .stream()
                .filter(task -> "active".equals(task.get("task_state")))
                .map(task -> task.get("assignee_id"))
                .distinct()
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }
}
