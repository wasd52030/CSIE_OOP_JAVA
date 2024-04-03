// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        var warr = getCharacter(Warrior.class);
        var arch = getCharacter(Archer.class);
        var mage = getCharacter(Mage.class);

        var eliteMoster = getCharacter(EliteMonster.class);

        show(warr, arch, mage, eliteMoster);

    }

    static <T extends RPGCharacter> T getCharacter(Class<T> characterType)
            throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        final var jobname = characterType.getSimpleName();

        System.out.printf("請輸入%s的名字: ", jobname);
        String name = scan.nextLine();
        System.out.printf("請輸入%s的等級: ", jobname);
        int level = Integer.valueOf(scan.nextLine());

        final var construct = characterType.getConstructor(String.class, int.class);
        return (T) construct.newInstance(name, level);
    }

    static void show(RPGCharacter... characters) {
        for (RPGCharacter character : characters) {
            System.out.printf("[%s]\n", character.getClass().getSimpleName());

            if (character instanceof Role) {
                System.out.print("[近戰攻擊] ");
                ((Role) character).attack();
            }

            if (character instanceof RemoteAttack) {
                System.out.print("[遠程攻擊] ");
                ((RemoteAttack) character).R_attack();
            }

            if (character instanceof Monster) {
                System.out.print("[技能] ");
                ((Monster) character).skill();
            }

            if (character instanceof Move) {
                ((Move) character).moveTo(MovePosition.DOWN);
            }

            System.out.println();
        }
    }
}