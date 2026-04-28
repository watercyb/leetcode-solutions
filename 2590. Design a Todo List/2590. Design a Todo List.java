/*
 * Problem: 2590. Design a Todo List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-todo-list/
 * Language: java
 * Date: 2026-04-28
 */

class TodoList {
    TaskList[] taskLists = new TaskList[100];
    int[] tasks = new int[100];
    int idx = 0;

    public TodoList() {

    }

    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        userId--;
        if (taskLists[userId] == null)
            taskLists[userId] = new TaskList();
        taskLists[userId].add(taskDescription, dueDate, tags);
        tasks[idx++] = dueDate;
        return idx;
    }

    public List<String> getAllTasks(int userId) {
        userId--;
        if (taskLists[userId] != null)
            return taskLists[userId].getAll();
        return new ArrayList<>();
    }

    public List<String> getTasksForTag(int userId, String tag) {
        userId--;
        if (taskLists[userId] != null)
            return taskLists[userId].get(tag);
        return new ArrayList<>();
    }

    public void completeTask(int userId, int taskId) {
        userId--;
        if (taskLists[userId] != null && tasks[taskId - 1] > 0)
            taskLists[userId].remove(tasks[taskId - 1]);
    }
}

class TaskList {
    String[] tasksByDueDate = new String[100];
    HashSet<String>[] tagsByDueDate = new HashSet[100];

    public void add(String task, int dueDate, List<String> tags) {
        dueDate--;
        tasksByDueDate[dueDate] = task;
        tagsByDueDate[dueDate] = new HashSet<>();
        tagsByDueDate[dueDate].addAll(tags);
    }

    public List<String> getAll() {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (tasksByDueDate[i] != null)
                res.add(tasksByDueDate[i]);
        }
        return res;
    }

    public List<String> get(String tag) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (tasksByDueDate[i] != null && tagsByDueDate[i].contains(tag))
                res.add(tasksByDueDate[i]);
        }
        return res;
    }

    public void remove(int dueDate) {
        dueDate--;
        tasksByDueDate[dueDate] = null;
    }
}

/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */
