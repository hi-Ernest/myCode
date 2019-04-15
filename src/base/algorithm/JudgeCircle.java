package base.algorithm;

public class JudgeCircle {

    public boolean judgeCircle(String moves) {

        char[] identification = {'U', 'D', 'L', 'R'};

        char[] input = moves.toCharArray();

        int[] count = {0,0,0,0};

        for(int i=0; i<input.length; i++) {
            for(int j=0; j<identification.length; j++) {
                if(input[i] == identification[j]) {
                    Character c = identification[j];
//                    map.put(c, i++);
                    switch (c) {
                        case 'U':count[0]++;break;
                        case 'D':count[1]++;break;
                        case 'L':count[2]++;break;
                        case 'R':count[3]++;break;
                    }
                }
            }
        }

        if(count[0] == count[1] && count[2] == count[3])
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("LDRRLRUULR"));
    }


//    public boolean judgeCircle(String moves) {
//        int i = 0, j = 0;
//        for(char ch : moves.toCharArray()){
//            switch(ch){
//                case 'R':
//                    j++; break;
//                case 'L':
//                    j--; break;
//                case 'D':
//                    i++; break;
//                case 'U':
//                    i--; break;
//            }
//        }
//        return i == 0 && j == 0;
//    }
}
