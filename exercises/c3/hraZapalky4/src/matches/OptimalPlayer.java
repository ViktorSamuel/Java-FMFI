package matches;

public class OptimalPlayer implements Player{
    @Override
    public int take(int totalMatches, int maxMatches){
        for(int i = maxMatches; i > 1 ; i--) {
            if((totalMatches-i) % (maxMatches+1) == 1) return i;
        }
        return 1;
    }
}
