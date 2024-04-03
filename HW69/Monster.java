public abstract class Monster extends RPGCharacter {

    public Monster(String name,int level){
        super(name,level);
    }

    abstract void skill();
}
