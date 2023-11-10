public class ByteCodeTest {

    public static void main(String[] args) {
        int a;
        try {
            a = 0;
        } catch (Exception e) {
            a = 1;
            throw new RuntimeException(e);
        } finally {
            a = 2;
        }
    }
}
