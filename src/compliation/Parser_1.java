//package compliation;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author chr
// * @Date 4/15/2019 10:50 PM
// * @Version 1.0
// */
//
//
///**
// * 先词法分析->放在str[]
// * 读取 token
// */
//public class Parser_1 {
//
//    private String token;
//
//    private int index = 0;
//
//    private List<String> list;
//
//    //符号+"i"
//    private static Map map;
//
//    //符号:+-*/()
//    private static Map map1;
//
//    private boolean boo = true;
//
//
//    public Parser_1(List list) {
//        this.list = list;
//        this.token = (String) list.get(index);
//
//        //判断是否为运算符->不是则令为"i"
//        if(!map1.containsValue(token))
//            token = "i";
//
//        System.out.println("list 的size: "+this.list.size());
//        index++;
//    }
//
//
//    public boolean E() throws ParserException {
//        T();
//        E1();
//        System.out.println(index);
//        return boo;
//    }
//
//    public void T() throws ParserException {
//        X();
//        T1();
//    }
//
//    public void X() throws ParserException {
//        Y();
//        X1();
//    }
//
//    public void Y() throws ParserException {
//        F();
//        Y1();
//    }
//
//
//    void E1() throws ParserException {
//
//        if(token.equals("+")){
//            match("+");
//            T();
//            E1();
//        }
//    }
//
//    public void T1() throws ParserException {
//        if(token.equals("*")) {
//            match("*");
//            F();
//            T1();
//        }
//    }
//
//    public void X1() throws ParserException {
//        if(token.equals("/")) {
//            token=" ";
//            match("/");
//            Y();
//            X1();
//        }
//    }
//
//    public void Y1() throws ParserException {
//        if(token.equals("*")) {
////            token=" ";
//            match("*");
//            F();
//            Y1();
//        }
//    }
//
//    public void F() throws ParserException {
//        if(token.equals("(")) {
////            token = " ";
//            match("(");
//            E();
//            if(token.equals(")")){
////                token = " ";
//                match(")");
//            }
//            else{
//                System.out.println("表达式错误：缺少')'");
//                boo = false;
//            }
//        }
//        else if(token.equals("i")) {
////            token = " ";
//            match("i");
//        }
//        else {
//            System.out.println("表达式错误");
//            boo = false;
//        }
//    }
//
//
//    public void match(String token1) {
//        boolean flag = false;
//
//        //符号+-*/()i
//        if (map.containsValue(token1)) {
//            if (index != list.size()) {
//                token = list.get(index);
//                //符号+-*/()
//                if (!map1.containsValue(token)) {
//                   token = "i";
//                }
//                index++;
//            }
//            flag = true;
//            token = list.get(index);
//        }
//
//        if (flag == false){
//            boo = false;
//        }
//    }
//
//    public static void main(String[] args) throws IOException, ParserException {
////        //接收的算数表达式
////        String expr;
////
////        //Scanner or BufferedReader
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////
////        SplitIdentifier_1 splitIdentifier_1 = new SplitIdentifier_1();
////
////        System.out.println("Enter an empty expression to stop.");
////
////        //一直输入直到输入为空结束
////        for(;;) {
////            System.out.print("Enter expression: ");
////            expr = br.readLine();
////            if ("".equals(expr)) {
////                break;
////            }
//
//            map = new HashMap();
//            map.put(1, "+");
//            map.put(2, "-");
//            map.put(3, "*");
//            map.put(4, "/");
//            map.put(5, "(");
//            map.put(6, ")");
//            map.put(7, "i");
//
//
//            map1 = new HashMap();
//            map1.putAll(map);
//            map1.remove(7);
//
//            List list = splitIdentifier_1.recognizeId(expr);
//
//            Parser_1 p = new Parser_1(list);
//
//            if(p.E())
//                System.out.println("正确表达式");
//            else
//                System.out.println("错误表达式");
//
//        }
//    }
//
//}
