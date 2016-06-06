package test;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(stringToInt("123"));

    }
    public static int stringToInt(String str){
        if (str==null || str.equals("")){
            throw new NumberFormatException("空字符串");
        }
        int result = 0;
        boolean negative = false;
        for (int i = 0; i < str.length(); i++) {
            if(i==0){
                char firstChar = str.charAt(0);
                if (firstChar=='-'){
                    negative = true;
                }
                if (firstChar=='+' || firstChar=='-'){
                    if (str.length()==1){
                        throw new NumberFormatException("无效字符串");
                    }
                    continue;
                }
            }
            int value = str.charAt(i)-'0';
            if(value<0 || value>9){
                throw new NumberFormatException("无效字符串");
            }
            result = result*10 + value;
            if (result<0){
                throw new NumberFormatException("超出int长度");
            }
        }

        return negative? -result:result;

    }

}


