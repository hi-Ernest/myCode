//package Test;
//
//import java.util.List;
//
//public class Arithmetic {
//	String t;
//	List<String> List;
//	boolean boo=true;
//	int k=0;
//	int j;
//	String[] s= {"+","-","*","/","(",")","i"};
//
//	public Arithmetic(List codeList) {
//		List= codeList;
//		this.t = List.get(k);
//
//		for( j=0;j<6;j++) {
//			if(t.equals(s[j])) {
//				break;
//			}
//		}
//
//		if(j==6) {
//			t="i";
//		}
//		k++;
//	}
//
//	public boolean E() {
//		T();
//		E1();
//		System.out.println(k);
//		return boo;
//	}
//
//    public void T() {
//		X();
//		T1();
//	}
//
//    public void X() {
//		Y();
//		X1();
//	}
//
//    public void Y() {
//		F();
//		Y1();
//	}
//
//    public void match(String token) {
//    	boolean result=false;
//
//	    	for(int i=0;i<7;i++) {
//	    		if(s[i].equals(token)) {
//	    			if(k!=List.size()) {
//		    			this.t = List.get(k);
//
//		    			for( j=0;j<6;j++) {
//		    				if(t.equals(s[j])) {
//		    					break;
//		    				}
//		    			}
//
//		    			if(j==6) {
//		    				t="i";
//		    			}
//		    			k++;
//	    			}
//	    			result=true;
//	    			break;
//	    		}
//	    	}
//
//	    	if(result==false) {
//	    		System.out.println("���ʽ����");
//	    		boo=false;
//	    	}
//
//
//    }
//
//    public void E1() {
//		if(t.equals("+")) {
//			t=" ";
//			match("+");
//			T();
//			E1();
//		}
//	}
//
//    public void T1() {
//		if(t.equals("-")) {
//			t=" ";
//			match("-");
//			X();
//			T1();
//		}
//	}
//
//    public void X1() {
//		if(t.equals("/")) {
//			t=" ";
//			match("/");
//			Y();
//			X1();
//		}
//	}
//
//    public void Y1() {
//		if(t.equals("*")) {
//			t=" ";
//			match("*");
//			F();
//			Y1();
//		}
//	}
//
//    public void F() {
//		if(t.equals("(")) {
//			t=" ";
//			match("(");
//			E();
//			if(t.equals(")")) {
//				t=" ";
//				match(")");
//			}else {
//				System.out.println("���ʽ����:û��'��'");
//				boo=false;
//			}
//		}else if(t.equals("i")) {
//			t=" ";
//			match("i");
//		}else {
//			System.out.println("���ʽ����");
//			boo=false;
//		}
//	}
//
//	public static void main(String[] args) {
//		SplitIdentifier_1 splitIdentifier_1 = new SplitIdentifier_1();
//
//		String expr = "a+(dd*d)+d*(ga3+eew)";
//		new Arithmetic(splitIdentifier_1.recognizeId(expr)).E();
//	}
//}
