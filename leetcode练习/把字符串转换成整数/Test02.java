package com.itheima.test02;

import java.util.Arrays;

public class Test02 {
    //写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
    //首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
    //当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号
    // ；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
    //该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
    //注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
    //在任何情况下，若函数不能进行有效的转换时，请返回 0。
    //说明：
    //假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−2^31, 2^31− 1]。如果数值超过这个范围，请返回 INT_MAX (2^31− 1) 或
    // INT_MIN (−2^31) 。

    public static void main(String[] args) {
        System.out.println(strToInt("12334"));
    }

    public static int strToInt(String str) {
        //先去空格再判空，不然" "教您做人，血的教训
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        //然后我想啊，下面要判断首位了
        //首位合格的无非就'+'或'-'或数字三种情况，其他的一概滚蛋
        //'+''-'肯定是要把它去掉的，这样三种情况就统一了
        //当然了，'-abc'这种有可能出现，不过只看首位它是没毛病的
        //让它进来，反正后面很容易解决
        //既然要去掉正负号，那肯定要出个boolean记一下是不是负数
        boolean isMinus = false;
        char[] ch = str.toCharArray();
        //首位是不是正负号或者数字啊
        if(ch[0] == '+' || ch[0] == '-' || Character.isDigit(ch[0])){
            //是不是正负号啊
            if(ch[0] == '+' || ch[0] == '-'){
                //是不是负号啊
                if(ch[0] == '-'){
                    isMinus = true;
                }
                //删除首位
                ch = Arrays.copyOfRange(ch,1,ch.length);
            }
            //首位搞定了就看后面是不是数字了，直到不是数字的地方或者倒底结束
            int index = 0;
            //结果可能超int范围，拿个long接一下
            //'-abc'这种情况返回的也是0，舒服，一箭双雕
            long res = 0;
            //短路与助您远离空指针喔，铁汁们，先后顺序关注一下
            while(index < ch.length && Character.isDigit(ch[index])){
                //一位一位往上算
                res *= 10;
                res += ch[index] - '0';
                //及时止损，一看到res超int范围立马return
                //你要是想着最后一起算，那肯定会有超long范围的测试用例等着你，你就哭去吧
                if(res > Integer.MAX_VALUE){
                    //正负号看是正数负数，返回最大值
                    return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                //别忘了往后走一位
                index++;
            }
            //long转int就是这么朴实无华
            return isMinus ? -(int)res : (int)res;
        }
        //兄弟首位都不对想啥呢，回去吧您
        return 0;
    }
}
