package tech.codinglink.demo.modle;

/**
 * json封装的基类
 */
public class BaseModle {
    /**
     *      code 为响应码，这里 0表示成功，1表示失败
     *      msg  返回信息，成功者返回成功的信息，错误者返回为什么错了
     *      count 返回数据的长度
     *      data  里存放我们的真实数据的集合  ，所以我们只需动态的改变他就可以了，当是文章这里填的是文章的集合，当时个人信息是则填个人信息的集合。
     */
    public int code;
    public String msg;
    public int count;


    public BaseModle(){
    }
    public BaseModle(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public BaseModle(int code,String msg,int count){
        this.code=code;
        this.msg=msg;
        this.count=count;
    }
}
