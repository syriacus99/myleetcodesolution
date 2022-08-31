import java.util.*;

public class Solution383RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        String[] magazineSplit = magazine.split("");
        String[] ransomNoteSplit = ransomNote.split("");
        List<String> magazineList = new ArrayList(Arrays.asList(magazineSplit));
        for(String eachChar : ransomNoteSplit){
            if(!magazineList.remove(eachChar)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abddd";
        System.out.println(a.substring(1,3));

        //System.out.println(canConstruct("aa","ab"));

    }
}
