package robots;

// Podtrida ProgrammedRobota kt ignoruje nezmyselne prikazy
public class CowardProgrammedRobot extends ProgrammedRobot{
    private int comandCount;

    // konstruktor vyuzivajuci nadtriedu
    public CowardProgrammedRobot(String[] comands){
        super(comands);
        this.comandCount = comands.length;
    }

    // vykonava len kroky kt vedu k pohybu
    @Override
    public String nextAction(View view) {
        for(int i = 0; i < comandCount; i++){
            String str = super.nextAction(view);
            if(str.equals("UP") && view.getUp().isAccessible()) return "UP";
            if(str.equals("RIGHT") && view.getRight().isAccessible()) return "RIGHT";
            if(str.equals("DOWN") && view.getDown().isAccessible()) return "DOWN";
            if(str.equals("LEFT") && view.getLeft().isAccessible()) return "LEFT";
            if(str.equals("SKIP")) return "SKIP";
//            switch (super.nextAction(view)){
//                case "UP":
//                    if(view.getUp().isAccessible()) return "UP";
//                case "RIGHT":
//                    if(view.getRight().isAccessible()) return "RIGHT";
//                case "DOWN":
//                    if(view.getDown().isAccessible()) return "DOWN";
//                case "LEFT":
//                    if(view.getLeft().isAccessible()) return "LEFT";
//                case "SKIP":
//                    return "SKIP";
//            }
        }
        return "SKIP";
    }
}
