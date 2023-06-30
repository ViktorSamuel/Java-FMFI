package robots;
public class DepthFirstSearchRobot implements Robot{
    private String[] commands = {"UP", "RIGHT", "DOWN", "LEFT"};
    private int opositeComand;
    private int n = 0;
    private boolean r = false;

    // vytvorenie robota na pociatocnej pozicii
    public DepthFirstSearchRobot(){
        this.opositeComand = -1;
    }

    // vykovanavie krokov a nasledne znacenie navratovj cesty
    // pri navrate neznaci navratovu cestu z navratu
    @Override
    public String nextAction(View view) {
        if(!r) n++;
        if(n % 2 == 1) return "PUT "+opositeComand;
        if(view.getUp().isAccessible() && view.getUp().getRecord() == 0) {
            opositeComand = 2+1;
            r = false;
            return "UP";
        }
        else if (view.getRight().isAccessible() && view.getRight().getRecord() == 0) {
            opositeComand = 3+1;
            r = false;
            return "RIGHT";
        }
        else if (view.getDown().isAccessible() && view.getDown().getRecord() == 0){
            opositeComand = 0+1;
            r = false;
            return "DOWN";
        }
        else if (view.getLeft().isAccessible() && view.getLeft().getRecord() == 0) {
            opositeComand = 1+1;
            r = false;
            return "LEFT";
        }
        else if (view.getHere().getRecord() != -1) {
            r = true;
            return commands[view.getHere().getRecord()-1];
        }
        else {
            return "SKIP";
        }
    }
}
