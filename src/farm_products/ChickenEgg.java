package farm_products;

public class ChickenEgg extends FarmProduct{
        private int type;   /*ChickenEgg type = 1*/
        private int price;  /*ChickenEgg price*/

        public ChickenEgg(){   /*constructor*/
			type =1;
			price =5;
		}

        /*return ChickenEgg type*/
        public int getType(){
			return type;
		}

        /*return ChickenEgg price*/
        public int getPrice(){
			return price;
		}
}

