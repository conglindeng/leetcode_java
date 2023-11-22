package limiting;

import limiting.model.Request;

public interface RequestLimit {

    default boolean requestLimit(Request request) {
        return false;
    }
}
