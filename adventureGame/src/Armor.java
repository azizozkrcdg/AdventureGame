public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price){
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorlist = new Armor[3];
        armorlist[0] = new Armor(1,"Hafif", 1,15);
        armorlist[1] = new Armor(2,"Orta", 3,25);
        armorlist[2] = new Armor(3,"Ağır", 5,40);

        return armorlist;
    }

    public static Armor getArmorObjById(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getblock(){
        return block;
    }

    public void setBlock(int block){
        this.block = block;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

}
