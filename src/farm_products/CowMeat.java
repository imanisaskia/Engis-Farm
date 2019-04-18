package farm_products;

public class CowMeat extends FarmProduct{
        private int type;   /*CowMeat type = 6*/
        private int price;  /*CowMeat price*/

        public CowMeat(){   /*constructor*/
			type =6;
			price =20;
		}

        /*return CowMeat type*/
        public int getType(){
			return type;
		}

        /*return CowMeat price*/
        public int getPrice(){
			return price;
		}
}


