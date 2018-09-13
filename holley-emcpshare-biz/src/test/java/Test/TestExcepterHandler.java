package Test;

public class TestExcepterHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程" + t.getName() + "出现异常。。。");

    }

}
