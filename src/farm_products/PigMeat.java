package farm_products;

public class PigMeat extends FarmProduct{
        private int type;   /*PigMeat type = 7*/
        private int price;  /*PigMeat price*/

        public PigMeat(){   /*constructor*/
			type =7;
			price =18;
		}

        /*return PigMeat type*/
        public int getType(){
			return type;
		}

        /*return PigMeat price*/
        public int getPrice(){
			return price;
		}
}


