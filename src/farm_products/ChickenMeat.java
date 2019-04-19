package farm_products;

public class ChickenMeat extends FarmProduct{
        private int type;   /*ChickenMeat type = 5*/
        private int price;  /*ChickenMeat price*/

        public ChickenMeat(){   /*constructor*/
			type =5;
			price =15;
		}

        /*return ChickenMeat type*/
        public int getType(){
			return type;
		}

        /*return ChickenMeat price*/
        public int getPrice(){
			return price;
		}
}


