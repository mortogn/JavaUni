
public class CallConstructor {

    int count;

    CallConstructor() {
        System.out.println("Call Constructor");
    }

    CallConstructor(int count) {
        this();
        this.count = 10;
    }

    void showCount() {
        System.out.println(count);
    }

    public static void main(String[] args) {
        CallConstructor cc = new CallConstructor(10);
        cc.showCount();
    }
}
