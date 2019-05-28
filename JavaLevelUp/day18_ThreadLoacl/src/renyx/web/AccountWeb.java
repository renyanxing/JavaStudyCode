package renyx.web;

import renyx.service.AccountService;
import renyx.service.AccountService2;

public class AccountWeb  {
    public static void main(String[] args) {
/*        Scanner sc=new Scanner(System.in);
        System.out.println("请输入付款人姓名");
        String fromName = sc.nextLine();
        System.out.println("请输入收款人姓名");
        String toName = sc.nextLine();
        System.out.println("请输入转账金额");
        double money = sc.nextDouble();*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                AccountService2 accSv2=new AccountService2();
                boolean transfer2 = accSv2.Transfer("rose", "tom", 1000);
                if (transfer2)
                    System.out.println("Rose to Tom 转账成功！");
                else
                    System.out.println("Rose to Tom转账失败！");
            }
        }).start();
        AccountService accSv=new AccountService();
        boolean transfer = accSv.Transfer("jack", "rose", 1000);
        if (transfer)
            System.out.println("Jack to Rose 转账成功！");
        else
            System.out.println("Jack to Rose转账失败！");
    }
}
