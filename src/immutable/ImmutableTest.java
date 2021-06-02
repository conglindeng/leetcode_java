package immutable;

import java.util.HashSet;
import java.util.Set;

public final class ImmutableTest {
    private final Set<String> set=new HashSet<>();
    public ImmutableTest() {
        set.add("1");
        set.add("2");
        set.add("3");
    }
}

