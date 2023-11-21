package limiting;

public interface RequestLimit {

    default boolean requestLimit(String IP) {
        return false;
    }
}
