package robots;

// robot kt drzi zvoleny smer pokil je mozne
public class DirectionRotatingRobot implements Robot {
    private String[] commands = {"UP", "RIGHT", "DOWN", "LEFT"};
    private int nextComand, n;

    // vytovorenie robota a nadstavenie prveho smeru pohybu
    public DirectionRotatingRobot(){
        this.nextComand = 0;
    }

    // vykovana svoj pohyb pokial je mozne, ak sa uz neda prejde na dalsi v poradi
    @Override
    public String nextAction(View view) {
        n = 0;
        while (n < 4){
            if(this.nextComand == 0){
                if(view.getUp().isAccessible()) return "UP";
                nextComand++;
                n++;
            }
            if (this.nextComand == 1){
                if (view.getRight().isAccessible()) return "RIGHT";
                nextComand++;
                n++;
            }
            if(this.nextComand == 2){
                if(view.getDown().isAccessible()) return "DOWN";
                nextComand++;
                n++;
            }
            if(this.nextComand == 3){
                if(view.getLeft().isAccessible()) return "LEFT";
                nextComand = 0;
                n++;
            }
        }
        return "SKIP";
    }
}
