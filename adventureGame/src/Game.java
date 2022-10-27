import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen İsminizi Giriniz : ");
        //String playerName = input.nextLine();
        Player player = new Player("Aziz");
        System.out.println("Hoşgeldin " + player.getName() + " maceraya hazır mısın?");
        System.out.println("Oyuna başlamak için bir karakter seçmelisin !");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("--------- Bölgeler ---------");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Burada düşman bulunmaz !");
            System.out.println("2 - Eşya Dükkanı --> Burada silah veya zırh satın alabilirsiniz !");
            System.out.println("3 - Mağara --> Ödül <Yemek> , dikkatli ol zombi çıkabilir !");
            System.out.println("4 - Orman --> Ödül <Odun> , dikkatli ol vampir çıkabilir !");
            System.out.println("5 - Nehir --> Ödül <Su> , dikkatli ol ayı çıkabilir !");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır !");

            System.out.print("Gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = input.nextInt();
            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge seçiniz !");
            }

            if (location == null){
                System.out.println("Oyun Sonlandırıldı !");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
