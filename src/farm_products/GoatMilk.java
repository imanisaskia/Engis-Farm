package farm_products;

public class GoatMilk extends FarmProduct{
        private int type;   /*GoatMilk type = 4*/
        private int price;  /*GoatMilk price*/

        public GoatMilk(){   /*constructor*/
			type =4;
			price =12;
		}

        /*return GoatMilk type*/
        public int getType(){
			return type;
		}

        /*return GoatMilk price*/
        public int getPrice(){
			return price;
		}
}


