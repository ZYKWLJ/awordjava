package com.spring.AOP.静态代理;

public class Client {
    private Subject subject=new Agent(new Host());
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.subject.rent();   
    }
}
