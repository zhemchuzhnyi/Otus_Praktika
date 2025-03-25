package animals.birds;

import static java.lang.System.*;

public interface IFlying {
    default void fly() {
        out.println("Я лечу");
    }
}
