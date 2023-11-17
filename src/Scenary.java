public class Scenary {

    //private static int state = 0;
    private static int round = 0;


    public static void greeting(){
        System.out.println("Здравствуйте, путники!\nНаверняка вам было скучно во время странствий.\nПредлагаю вам посмотреть на сражение группы авантюристов!)");
    }
    public static void choiceGameMode(){
        System.out.println("Группа авантюристов предлагает вам стать руководить сражением. Вы согласны?\n(1 - Авт. управление, 2 - Полуавт. управление, 3 - Ручное управление)\nУкажите свой выбор: ");
    }
    public static void choiceName(){
        System.out.println("Как нам тебя называть, странник?\nУкажи свое имя: ");
    }
    public static void choiceUnits(){
        System.out.println("Выбери трех авантюристов, которыми ты будешь руководить в предстоящей битве!\n(1 - Рыцарь, 2 - Терминатор, 3 - Маг)\nУкажи свой выбор: ");
    }
    public static void choiceUnit(Player player){
        System.out.println("Состояние ваших авантюристов:");
        player.printUnitsParameters();
        System.out.println("Выбери авантюриста, который сейчас будет атаковать!\nУкажи его номер: ");
    }
    public static void enemyInfo(Player enemy){
        System.out.println("Состояние группы авантюристов, руководитель которой - " + enemy.getName() + ":");
        enemy.printUnitsParameters();
    }

    public static void choiceAction(){
        System.out.println("Ваш авантюрист может использовать ультимейт, либо провести обычную атаку!\n(1 - Атака, 2 - Ультимейт)\nУкажите его действие: ");
    }
    public static void choiceTarget(){
        System.out.println("Выбери бойца противника, которого нужно атаковать!\nУкажи его номер: ");
    }
    public static void nextPlayerChoose() {
        System.out.println("Отлично! Ожидайте начала битвы, а я тем временем поговорю со следующим странником.\n");
    }
    public static void startFight(String name){
        System.out.println("Сейчас жребием я определю, какая из групп авантюристов начнет сражение первой!\nБитва начинается!!!\n");
    }
    public static void newTurn(String name){
        round++;
        System.out.println("Сейчас " + round + " раунд. Ходит " + name + '.');
    }
    public static void gameOver(String name){
        System.out.println(name + ", к сожалению твоя группа авантюристов полностью разбита, ты проиграл...");
    }
    public static void theEnd(String name){
        System.out.println("Битва окончена, победителем становится " + name + "!!!\nОн победил за " + round + " раундов");
    }
}
