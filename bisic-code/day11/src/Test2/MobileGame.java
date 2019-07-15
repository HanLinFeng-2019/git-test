package Test2;

public class MobileGame extends Game {
    @Override
    public void paly() {
        System.out.println("名称为"+super.getName()+"的"+super.getType()+"类游戏非常流行。");
    }

    public MobileGame() {
    }

    public MobileGame(String type, String name) {
        super(type, name);
    }
    private void efforts(){
        System.out.println("晚上不睡觉玩"+super.getName());
    }
    private void damage(){
        System.out.println("导致白天上课困，毕业后找不到工作");
    }
    public void prepare(){
        efforts();
        damage();
    }

}
