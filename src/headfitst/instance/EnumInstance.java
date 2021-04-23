package headfitst.instance;

import java.util.Optional;

public enum EnumInstance {

    INSTANCE;


    public <T> Optional<T> getOptinal(T t){
        return Optional.of(t);
    }

}
