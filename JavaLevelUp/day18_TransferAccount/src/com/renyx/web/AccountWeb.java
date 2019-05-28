package com.renyx.web;

import com.renyx.service.AccountService;

import java.util.Scanner;

public class AccountWeb  {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入付款人姓名");
        String fromName = sc.nextLine();
        System.out.println("请输入收款人姓名");
        String toName = sc.nextLine();
        System.out.println("请输入转账金额");
        double money = sc.nextDouble();
        AccountService accSv=new AccountService();
        boolean transfer = accSv.Transfer(fromName, toName, money);
        if (transfer)
            System.out.println("转账成功！");
        else
            System.out.println("转账失败！");
    }
}
