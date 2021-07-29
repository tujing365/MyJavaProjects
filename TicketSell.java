/*
实现一个由A、B、C三个窗口同时销售100张票的系统，
要求打印出每个窗口打印的售票情况，
并且每个窗口不得连续售票。
 */
public class TicketSell {
    private int num = 100;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public synchronized void sellTicket(int i) {
        if (num > 0) {
            num -= i;
            System.out.println(Thread.currentThread().getName() + "买票" + i + "张，还剩" + num + "张");
        } else {
            System.out.println("没票了");
        }
        notify();
        try {
            wait();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        TicketSell t1 = new TicketSell();
        BroughtThread w1 = new BroughtThread("甲", t1, 1);
        BroughtThread w2 = new BroughtThread("乙", t1, 1);
        BroughtThread w3 = new BroughtThread("丙", t1, 1);
        w1.start();
        w2.start();
        w3.start();
    }
}
class BroughtThread extends Thread {
    private TicketSell ticketSell;
    private int broughtAmount;
    public BroughtThread (String name, TicketSell ticketSell, int broughtAmount) {
        super(name);
        this.broughtAmount = broughtAmount;
        this.ticketSell = ticketSell;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.ticketSell.sellTicket(broughtAmount);
        }

    }

}
