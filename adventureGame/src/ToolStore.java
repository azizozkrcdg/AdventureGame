
public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------- Mağazaya Hoşgeldin ! ---------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Mağazadan Ayrıl");
            System.out.print("Seçiminiz : ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Lütfen geçerli bir değer girin !");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar Bekleriz !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("------ Silahlar ------");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " < Fiyat : " + w.getPrice() + " , Hasar : " + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");

    }

    public void buyWeapon() {
        System.out.print("Bir silah seçin : ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Lütfen geçerli bir değer giriniz !");
            selectWeaponId = input.nextInt();
        }

        if (selectWeaponId != 0) {
            Weapon selecetedWeapon = Weapon.getWeaponObjById(selectWeaponId);

            if (selecetedWeapon != null) {
                if (selecetedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli miktarda paranız bulunmamaktadır !");
                } else {
                    // Satın Alma İşlemi
                    System.out.println(selecetedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selecetedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selecetedWeapon);
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("------ Zırhlar ------");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " < Fiyat : " + a.getPrice() + " , Zırh Değeri : " + a.getblock() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçin : ");

        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Lütfen geçerli bir değer girin : ");
            selectArmorId = input.nextInt();

        }

        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli miktarda paranız bulunmamaktadır !");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan bakiyeniz : " + this.getPlayer().getMoney());
                }
            }
        }
    }
}