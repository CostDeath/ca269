package week2;

import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {
    // Class Properties
    private final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline;
    private State state;

    // Constructor
    Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    // Getters & Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public LocalDate getScheduled() {
        return scheduled;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    // toString method
    public String toString() {
        String message = title + " (" + state + ")";
        if(scheduled != null) message += " scheduled: " + scheduled;
        if(deadline != null) message += " deadline: " + deadline;
        return message;
    }
}

class Chore extends Task {
    // Class Properties
    private LocalDate repeat;

    // Constructor
    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    // Getters & Setters
    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

    public LocalDate getRepeat() {
        return repeat;
    }

    @Override
    public void setState(State state) {
        if(state == State.DONE) {
            setScheduled(repeat);
            setRepeat(repeat.plus(Period.ofDays(7)));
        }
    }
}

class RepeatedTask extends Task {
    // Constructor
    RepeatedTask(String title, State state) {
        super(title, state);
    }

    // Setter Override
    @Override
    public void setState(State state) {
        if(state == State.DONE) super.setState(State.TODO);
        else super.setState(state);
    }
}

class SharedTask extends Task {
    // Class properties
    private String name;

    SharedTask(String title, String name) {
        super(title, State.WAIT);
        this.name = name;
    }

    // String Override
    @Override
    public String toString() {
        String message = super.toString();
        message += " shared with: " + name;
        return message;
    }
}

class Dependency extends Task {
    // Class properties
    private Task dependency;

    // Constructor
    Dependency(String title, State state, Task dependency) {
        super(title, state);
        this.dependency = dependency;
    }

    // Setter Override
    @Override
    public void setState(State state) {
        if(dependency.getState() == State.DONE) super.setState(state);
    }

    // String Override
    @Override
    public String toString() {
        String message = super.toString();
        message += " dependent on: " + dependency;
        return message;
    }
}