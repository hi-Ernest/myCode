package compliation.result;

import java.util.ArrayList;
import java.util.List;

public class Identifier {
	
	private List<String> codeList=new ArrayList<>();

	public List  identifier(String str,List<String> list) {

		//状态转化->控制进入不同的方法
		char state='0';

		boolean result=true;
		int k=0;
		int first = 0;

		while(result==true) {
			
			switch(state) {
			case '0':
				first=k;
				if(Character.isLetter(str.charAt(k))) {
					state='1';
					k++;
				}
				else if(Character.isDigit(str.charAt(k))) {
					state='3';
					k++;
				}else if(str.charAt(k)==' ') {
					state='0';
					
					if(k==str.length())
						result=false;
					k++;
				}else {
					k++;
					
					boolean t=true,t1=true;
					if(k!=str.length()) {
						if(str.charAt(k-1)=='|'||str.charAt(k-1)=='&'||str.charAt(k-1)=='=') {
							if(str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='=') {
								k++;
								for(int i=0;i<list.size();i++) {
									if((str.substring(first, k)).equals(list.get(i))) {
										codeList.add(str.substring(first, k));
										t=false;
										
									}
								}
								t1=false;
							}
						
						}
					}
					
					if(t1==true)
					{
						for(int i=0;i<list.size();i++) {
							if((str.substring(first, k)).equals(list.get(i))) {
								codeList.add((str.substring(first, k)));
								t=false;
							}
						}
					}
					
					if(t==true) {
	
						codeList.add(str.substring(first, k));
					}
					
					state='0';
					
					if(k==(int)str.length())
						result=false;
				
				}
				break;
				
			case '1':
				if(k!=str.length()) {
					if(Character.isDigit(str.charAt(k))||Character.isLetter(str.charAt(k))) {
						state='1';
						k++;
					}else if(str.charAt(k)==' '||str.charAt(k)=='='||str.charAt(k)=='+'||str.charAt(k)=='-'||str.charAt(k)=='*'||str.charAt(k)=='/'||str.charAt(k)=='('||str.charAt(k)==')'||str.charAt(k)==';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!'){
						state='2';
					}else {
						while(k!=str.length()&&(str.charAt(k)!=' '||str.charAt(k)!='='||str.charAt(k)!='+'||str.charAt(k)!='-'||str.charAt(k)!='*'||str.charAt(k)!='/'||str.charAt(k)!='('||str.charAt(k)!=')'||str.charAt(k)!=';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!')) {
							if(str.charAt(k)!=' '||str.charAt(k)!='='||str.charAt(k)!='+'||str.charAt(k)!='-'||str.charAt(k)!='*'||str.charAt(k)!='/'||str.charAt(k)!='('||str.charAt(k)!=')'||str.charAt(k)!=';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!') {
								k++;
							}
						}
						state='9';
					}
				}else
					state='2';
				break;
				
			case '2':
				boolean t=true;
				for(int i=0;i<list.size();i++) {
					if((str.substring(first, k)).equals(list.get(i))) {
						codeList.add(str.substring(first, k));
						t=false;
					}
				}
				
				if(t==true) {
					codeList.add(str.substring(first, k));
				}
				state='0';
				if(k==str.length())
					result=false;
				break;
				
			case '3':
				if(k!=str.length()) {
					if(Character.isDigit(str.charAt(k))) {
						state='3';
						k++;
					}else if(str.charAt(k)==' '||str.charAt(k)=='='||str.charAt(k)=='+'||str.charAt(k)=='-'||str.charAt(k)=='*'||str.charAt(k)=='/'||str.charAt(k)=='('||str.charAt(k)==')'||str.charAt(k)==';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!'){
						state='4';
					}else {
						while(k!=(int)str.length()&&(str.charAt(k)!=' '||str.charAt(k)!='='||str.charAt(k)!='+'||str.charAt(k)!='-'||str.charAt(k)!='*'||str.charAt(k)!='/'||str.charAt(k)!='('||str.charAt(k)!=')'||str.charAt(k)!=';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!')) {
							if(str.charAt(k)!=' '||str.charAt(k)!='='||str.charAt(k)!='+'||str.charAt(k)!='-'||str.charAt(k)!='*'||str.charAt(k)!='/'||str.charAt(k)!='('||str.charAt(k)!=')'||str.charAt(k)!=';'|| str.charAt(k)=='|'||str.charAt(k)=='&'||str.charAt(k)=='!') {
								k++;
							}
						}
						state='9';
					}
				}else
					state='4';
				
				break;
				
			case '4':
				codeList.add(str.substring(first, k));
				state='0';
				if(k==str.length())
					result=false;
				break;

			case '9':
				codeList.add(str.substring(first, k));
				state='0';
				
				if(k==str.length())
					result=false;
				break;
			}
		}
		
		return codeList;
		
	}


	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "a&&b||cc(ds||ss)";

		List<String> list = new ArrayList<>();
		Identifier identifier = new Identifier();

		System.out.println(identifier.identifier(str, list));
	}
	
}
