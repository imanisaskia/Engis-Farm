package farm_products;

public class RabbitMeat extends FarmProduct{
        private int type;   /*RabbitMeat type = 8*/
        private int price;  /*RabbitMeat price*/

        public RabbitMeat(){   /*constructor*/
			type =8;
			price =17;
		}

        /*return RabbitMeat type*/
        public int getType(){
			return type;
		}

        /*return RabbitMeat price*/
        public int getPrice(){
			return price;
		}
}


