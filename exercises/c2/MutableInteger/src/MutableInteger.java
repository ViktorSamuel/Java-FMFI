public class MutableInteger {

    private int value;

    public MutableInteger(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
            this.value = value;
    }

    public static void swap(MutableInteger a, MutableInteger b){
        int x = a.getValue();
        a.setValue(b.getValue());
        b.setValue(x);
    }
}
