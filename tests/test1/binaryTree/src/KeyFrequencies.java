import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyFrequencies {
    public static void inOrderKeys(Node root, List<String> list){
        if(root != null){
            inOrderKeys(root.getLeft(), list);
            list.add(root.getKey());
            inOrderKeys(root.getRight(), list);
        }
    }
    public static String[] arrayOfKeys(Node root){
        List<String> list = new ArrayList<>();
        inOrderKeys(root, list);

        String[] keys =  new String[list.size()];
        for(int i = 0; i < keys.length; i++) keys[i] = list.get(i);

        return keys;
    }
    public static int keyFrequency(Node root, String key){
        if (root == null) return 0;

        String[] keys = Arrays.copyOf(arrayOfKeys(root), arrayOfKeys(root).length);

        int frequency = 0;
        for (String str: keys) {
            if (str.equals(key)) frequency++;
        }

        return frequency;
    }
    public static int maximumKeyFrequency(Node root){
        if (root == null) return 0;

        String[] keys = Arrays.copyOf(arrayOfKeys(root), arrayOfKeys(root).length);

        int maxFrequency = 0;
        for (int i = 0; i < keys.length; i++){
            int frequency = 0;

            for (int j = 0; j < keys.length; j++){
                if(keys[i].equals(keys[j])) frequency++;
            }

            if (frequency > maxFrequency) maxFrequency = frequency;
        }

        return maxFrequency;
    }
}

