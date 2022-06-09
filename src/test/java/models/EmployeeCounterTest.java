package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeCounterTest {
    @Test
    public void whenTwoUniqueEmployee() {
        List<HashMap<String, String>> projectsTasks = new ArrayList<>();
        HashMap<String, String> firstTask  = new HashMap<>() {{
            put("task_id", "1");
            put("assignee_id", "001");
            put("task_state", "active");
        }};
        HashMap<String, String> secondTask  = new HashMap<>() {{
            put("task_id", "2");
            put("assignee_id", "002");
            put("task_state", "active");
        }};
        HashMap<String, String> thirdTask  = new HashMap<>() {{
            put("task_id", "3");
            put("assignee_id", "001");
            put("task_state", "active");
        }};
        HashMap<String, String> fourthTask  = new HashMap<>() {{
            put("task_id", "4");
            put("assignee_id", "007");
            put("task_state", "disabled");
        }};
        projectsTasks.add(firstTask);
        projectsTasks.add(secondTask);
        projectsTasks.add(thirdTask);
        projectsTasks.add(fourthTask);
        Assert.assertEquals(2, EmployeeCounter.countUniqueEmployees(projectsTasks));
    }

    @Test
    public void whenZeroUniqueEmployee() {
        List<HashMap<String, String>> projectsTasks = new ArrayList<>();
        HashMap<String, String> firstTask  = new HashMap<>() {{
            put("task_id", "1");
            put("assignee_id", "001");
            put("task_state", "disabled");
        }};
        HashMap<String, String> secondTask  = new HashMap<>() {{
            put("task_id", "2");
            put("assignee_id", "002");
            put("task_state", "disabled");
        }};
        HashMap<String, String> thirdTask  = new HashMap<>() {{
            put("task_id", "3");
            put("assignee_id", "001");
            put("task_state", "disabled");
        }};
        HashMap<String, String> fourthTask  = new HashMap<>() {{
            put("task_id", "4");
            put("assignee_id", "007");
            put("task_state", "disabled");
        }};
        projectsTasks.add(firstTask);
        projectsTasks.add(secondTask);
        projectsTasks.add(thirdTask);
        projectsTasks.add(fourthTask);
        Assert.assertEquals(0, EmployeeCounter.countUniqueEmployees(projectsTasks));
    }

    @Test
    public void whenOneUniqueEmployee() {
        List<HashMap<String, String>> projectsTasks = new ArrayList<>();
        HashMap<String, String> firstTask  = new HashMap<>() {{
            put("task_id", "1");
            put("assignee_id", "001");
            put("task_state", "active");
        }};
        HashMap<String, String> secondTask  = new HashMap<>() {{
            put("task_id", "2");
            put("assignee_id", "001");
            put("task_state", "disabled");
        }};
        HashMap<String, String> thirdTask  = new HashMap<>() {{
            put("task_id", "3");
            put("assignee_id", "001");
            put("task_state", "active");
        }};
        HashMap<String, String> fourthTask  = new HashMap<>() {{
            put("task_id", "4");
            put("assignee_id", "001");
            put("task_state", "active");
        }};
        projectsTasks.add(firstTask);
        projectsTasks.add(secondTask);
        projectsTasks.add(thirdTask);
        projectsTasks.add(fourthTask);
        Assert.assertEquals(1, EmployeeCounter.countUniqueEmployees(projectsTasks));
    }
}