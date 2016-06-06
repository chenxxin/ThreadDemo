/**
 * Created by xin on 2016/5/13.
 */
public class StringTest {
    public static void main(String[] args) {
        char[] ch = new char[20];
        ch="We are happy.".toCharArray();
        System.out.println("ch = " + ch.length);
        System.out.println(replaceBank(ch,20).toString());
    }
    public static char[] replaceBank(char[] ch,int length){
        int len = ch.length;
        System.out.println("len = " + len);

        for (int i = 0; i < ch.length; i++) {
            if (ch[i]==' '){
                len+=2;
            }
        }
        System.out.println("len = " + len);
        for (int i = ch.length-1; i >= 0 ; i--) {
            if (ch[i]!=' '){
                ch[--len] = ch[i];
            }else {
                ch[--len]='0';
                ch[--len]='2';
                ch[--len]='%';
            }
        }
        System.out.println("ch = " + ch.length);
        return ch;
    }
}
