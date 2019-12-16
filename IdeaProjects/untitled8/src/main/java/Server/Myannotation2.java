package Server;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Inherited
public @interface Myannotation2 {
    String value();
    String name();
}

