package farm_products;

public class CowMilk extends FarmProduct{
        private int type;   /*CowMilk type = 3*/
        private int price;  /*CowMilk price*/

        public CowMilk(){   /*constructor*/
			type =3;
			price =10;
		}

        /*return CowMilk type*/
        public int getType(){
			return type;
		}

        /*return CowMilk price*/
        public int getPrice(){
			return price;
		}
}


