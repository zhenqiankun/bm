package Server;

import java.lang.annotation.Retention;

@MyAnnotation(name = "happy")
@Myannotation2(value = "jjj", name = "kkk")
@Myannotation3({"hh","ttt"})
public class People {
    @Override
    public String toString() {
        return "banuan";
    }

    @Deprecated
    @MyAnnotation(name = "SAD")
    public String getName(){
        return "hJKDSAKDASappy";
    }


    @MyAnnotation
    public Integer getAge(){
        return 20;
    }
}
