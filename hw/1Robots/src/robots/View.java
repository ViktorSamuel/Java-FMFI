package robots;

/** Trieda reprezentujuca "vyhlad" robota z jeho pozicie v labyrinte. Ide o "obal" pre pat instancii triedy Square,
 *  ktore reprezentuju policko, na ktorom sa robot momentalne nachadza a styri susedne policka.
 *  K tymto polickam mozno pristupovat pomocou verejnych metod get, ale nemozno ich menit. */
public class View {
    private Square here;
    private Square up;
    private Square right;
    private Square down;
    private Square left;

    public View(Square here, Square up, Square right, Square down, Square left) {
        this.here = here;
        this.up = up;
        this.right = right;
        this.down = down;
        this.left = left;
    }

    public Square getHere() {
        return here;
    }

    public Square getUp() {
        return up;
    }

    public Square getRight() {
        return right;
    }

    public Square getDown() {
        return down;
    }

    public Square getLeft() {
        return left;
    }
}
