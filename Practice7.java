/*
1)启动两个线程对一个数字i操作（10分）
2)其中1个线程每次对i加1（10分）
3)另1个线程每次对i减一（10分）
4)各运行20次，结果i的值等于初始值。（20分）
 */
public class Practice7 {
    private int count = 20;//计数器

    public int getCount() {
        return count;
    }

    boolean flag = true;//设置旗标

    public synchronized void add() {
        if (flag) {
            count += 1;
            flag = false;
            System.out.println(count);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sub() {
        if (!flag) {
            count -= 1;
            flag = true;
            System.out.println(count);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Practice7 practice7 = new Practice7();
        CountThread c1 = new CountThread("add", practice7);
        CountThread c2 = new CountThread("sub", practice7);
        c1.start();
        c2.start();

    }
}

class CountThread extends Thread {
    private Practice7 practice7;
    public CountThread(String name, Practice7 practice7) {
        super(name);
        this.practice7 = practice7;

    }
    //根据线程名决定加和减
    public void run() {
        if (Thread.currentThread().getName().equals("add")) {
            for (int i = 0; i < 20; i++) {
                this.practice7.add();
            }
        } else if (Thread.currentThread().getName().equals("sub")){
            for (int i = 0; i < 20; i++) {
                this.practice7.sub();
            }

        }
    }

}
