package Exercise1;

public class Main {
    private int i;
    private static int primitive = 11;
    private static Integer reference = 5;
    static long lastTime;

    Main(int i){
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public static boolean isEqualsFive(int ...ints){
        lastTime = System.nanoTime();
        for (int i:ints){
            if (i == 5)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Main main = new Main(7);

        System.out.println(main.getI());
        System.out.println(primitive);
        System.out.println(reference);

        System.out.println(isEqualsFive(main.getI(),primitive,reference));
        long currentTime = System.nanoTime();
        float time = (currentTime - lastTime) * 0.000000001f;
        System.out.println(time);
    }
}
