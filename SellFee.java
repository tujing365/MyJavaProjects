/*
模拟3个人排除买票，每人买1张票。售货员只有1张五元的钱，电影票5元一张，
王大拿拿一张二十元的人民币排在谢大脚前面买票，
谢大脚拿1张十元的人民币排在在赵四的前面买票，
赵四拿1张五元的人民币排在最后。即最终的卖票次序是：谢大脚、赵四、王大拿
 */
public class SellFee {
    private int change = 5;
    private final int FEE = 5;

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public void sellFee(int money)  {
       synchronized (this) {
           if (this.getChange() < (money - FEE)) {
               //System.out.println(Thread.currentThread().getName());
               try {
                   wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           if ((this.getChange() > (money - FEE)) || (this.getChange() == (money - FEE))) {
               this.change += FEE;
               System.out.println(Thread.currentThread().getName() + "买票成功！");
               if (this.getChange() ==  15) {//有零钱时通知王大拿
                   notify();
               }

           }
           //System.out.println(Thread.currentThread().getName() + "vv");
       }
    }

    public static void main(String[] args) {
        SellFee sellFee = new SellFee();
        BuyFee buyFee1 = new BuyFee("王大拿", 20, sellFee);
        BuyFee buyFee2 = new BuyFee("谢大脚", 10, sellFee);
        BuyFee buyFee3 = new BuyFee("赵四", 5, sellFee);
        buyFee1.setPriority(Thread.MAX_PRIORITY);
        buyFee2.setPriority(Thread.NORM_PRIORITY);
        buyFee3.setPriority(Thread.MIN_PRIORITY);
        buyFee1.start();
        buyFee2.start();
        buyFee3.start();


    }
}
class BuyFee extends Thread{
    private int moneny;
    private SellFee s;

    public int getMoneny() {
        return moneny;
    }

    public void setMoneny(int moneny) {
        this.moneny = moneny;
    }

    public BuyFee(String name, int moneny, SellFee s) {
        super(name);
        this.s = s;
        this.moneny = moneny;
    }
    public void run() {
        //System.out.println(Thread.currentThread().getName() + "开始跑了");
        s.sellFee(moneny);
    }

}
