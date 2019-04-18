package farm_products;

public class DuckEgg extends FarmProduct{
        private int type;   /*DuckEgg type = 2*/
        private int price;  /*DuckEgg price*/

        public DuckEgg(){   /*constructor*/
			type =2;
			price =7;
		}

        /*return DuckEgg type*/
        public int getType(){
			return type;
		}

        /*return DuckEgg price*/
        public int getPrice(){
			return price;
		}
}


