package week2;

import java.time.LocalDate;
import java.time.Period;

public class Test {
    public static void main(String[] args) {
        Task t1 = new Task("T1", State.TODO);
        LocalDate now = LocalDate.now();
        LocalDate.now();
        System.out.println(t1);

    /* OUTPUT
    T1 (TODO)
    */

        Task s1 = new RepeatedTask("S1", State.TODO);
        System.out.println(s1);
        s1.setState(State.DONE);
        System.out.println(s1);

    /* OUTPUT
    S1 (TODO)
    S1 (TODO)
    */

        Task s2 = new Chore("S2", State.TODO,
                LocalDate.now(),
                LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(s2);
        s2.setState(State.DONE);
        System.out.println(s2);

    /* OUTPUT
    S2 (TODO) scheduled: 2023-01-26
    S2 (TODO) scheduled: 2023-02-02
    */

        Task t2 = new SharedTask("T2", "Alice");
        System.out.println(t2);

    /* OUTPUT
    T2 (WAIT) shared with: Alice
    */

        Task t3 = new Dependency("T3", State.TODO, t1);
        System.out.println(t3);
        t3.setState(State.DONE);
        System.out.println(t3);
        t1.setState(State.DONE);
        t3.setState(State.DONE);
        System.out.println(t3);

    /* OUTPUT
    T3 (TODO) dependent on: T1 (TODO)
    T3 (TODO) dependent on: T1 (TODO)
    T3 (DONE) dependent on: T1 (DONE)
    */
    }
}
